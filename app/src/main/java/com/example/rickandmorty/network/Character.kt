package com.example.rickandmorty.network

import com.squareup.moshi.Json

data class Character(
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "species")
    val species: String
)

data class CharacterResponse(
    @Json(name = "results")
    val result: List<Character>)
