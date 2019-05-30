package com.devundefined.pokemontestapp.infrastructure.backend

import com.devundefined.pokemontestapp.infrastructure.backend.dto.PokemonDto
import com.devundefined.pokemontestapp.infrastructure.backend.dto.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonInfoApi {

    @GET("api/v2/pokemon/?offset=0&limit=964")
    fun getPokemonInfoList(): PokemonListDto

    @GET("api/v2/pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): PokemonDto
}