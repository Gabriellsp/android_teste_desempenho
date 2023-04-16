package com.example.androidteste.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidteste.R
import com.example.androidteste.database.SQLiteHelper
import com.example.androidteste.models.MarvelCharacter
import com.example.androidteste.services.MarvelClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataRenderingPage : AppCompatActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_data_rendering)
        val recyclerView = findViewById<RecyclerView>(R.id.marvelList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val charsList: ArrayList<MarvelCharacter> = ArrayList()
        val database = SQLiteHelper(this);
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 0..1000 step 100) {
                val result =  MarvelClient.api.list(
                    ts = 1,
                    orderBy = "name",
                    limit = 100,
                    offset = i,
                    apikey = "422190db783a962029ff4735e165cb88",
                    hash = "3b5c77dd93627ad07e11a02afa9c7239"
                );
                val listMarvel = result.data.results
                println(result)
                charsList.addAll(listMarvel)
            }
            for(charMarvel in charsList){
                database.insertMarvelCharacter(charMarvel)
            }
            withContext(Dispatchers.Main) {
                recyclerView.adapter = MarvelAdapter(charsList)
            }
        }
    }
}