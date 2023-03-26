package com.example.androidteste.view

import com.example.androidteste.services.MarvelClient
import android.os.Bundle
import com.example.androidteste.R
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidteste.models.MarvelCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRenderingPage : AppCompatActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_data_rendering)
        val recyclerView = findViewById<RecyclerView>(R.id.marvelList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val result =   MarvelClient.api.list(
            ts = 1,
            orderBy = "name",
            limit = 100,
            offset = 0,
            apikey = "422190db783a962029ff4735e165cb88",
            hash = "3b5c77dd93627ad07e11a02afa9c7239"
        )
        result.enqueue(object : Callback<List<MarvelCharacter>> {
            override fun onResponse(call: Call<List<MarvelCharacter>>, response: Response<List<MarvelCharacter>>) {
                val listMarvel = response.body()
                recyclerView.adapter = MarvelAdapter(listMarvel!!)
                println(listMarvel)
            }

            override fun onFailure(call: Call<List<MarvelCharacter>>, t: Throwable) {
                println("Erro ao buscar usuário: ${t.message}")
            }
        })
    }
}