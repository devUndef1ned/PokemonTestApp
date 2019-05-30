package com.devundefined.pokemontestapp.infrastructure.backend.dto

import com.google.gson.annotations.SerializedName

class PokemonListDto(@SerializedName("results") val results: List<PokemonInfoDto>)