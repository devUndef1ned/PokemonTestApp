package com.devundefined.pokemontestapp.domain.services

import com.devundefined.pokemontestapp.domain.models.Pokemon

interface PokemonLoadService {
    fun loadPokemons(): List<Pokemon>
}