package com.example.androidteste.models

import com.google.gson.annotations.SerializedName

data class CharacterThumbnail(
    @SerializedName("path")
    var path: String,
    @SerializedName("extension")
    var extension: String
)