package com.example.androidteste.services
import com.example.androidteste.models.MarvelCharacter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {
    @GET("/v1/public/characters")
    fun list(@Query("ts") ts: Int,
             @Query("orderBy") orderBy: String,
             @Query("limit") limit: Int,
             @Query("offset") offset: Int,
             @Query("apikey") apikey: String,
             @Query("hash") hash: String,
    ): Call<List<MarvelCharacter>>

}