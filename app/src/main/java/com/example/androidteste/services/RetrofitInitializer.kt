package com.example.androidteste.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelClient {
//    private const val apiKey = "422190db783a962029ff4735e165cb88";
//    private const val hash = "3b5c77dd93627ad07e11a02afa9c7239";
//    private val  okHttpClient =  OkHttpClient.Builder().addInterceptor(
//        Interceptor { chain ->
//        val url = chain.request()
//            .url()
//            .newBuilder()
//            .addQueryParameter("ts", "1")
//            .addQueryParameter("orderBy", "name")
//            .addQueryParameter("limit", "100")
//            .addQueryParameter("offset", "0")
//            .addQueryParameter("apiKey", apiKey)
//            .addQueryParameter("hash", hash)
//            .build()
//        val request = chain.request()
//            .newBuilder()
//            .url(url)
//            .build()
//        return@Interceptor chain.proceed(request)
//    }
//    ).build();
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(MarvelService::class.java)
}