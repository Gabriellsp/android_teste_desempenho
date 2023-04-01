package com.example.androidteste.models

import com.google.gson.annotations.SerializedName

data class MarvelCharacter(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("thumbnail")
    var thumbnail: CharacterThumbnail?
)