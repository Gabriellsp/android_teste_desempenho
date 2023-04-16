package com.example.androidteste.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(MarvelService::class.java)
}