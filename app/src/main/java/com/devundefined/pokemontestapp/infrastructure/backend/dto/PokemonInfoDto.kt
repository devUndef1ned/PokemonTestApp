package com.devundefined.pokemontestapp.infrastructure.backend.dto

import com.google.gson.annotations.SerializedName

class PokemonInfoDto(@SerializedName("name") val name: String, @SerializedName("url") val url: String)