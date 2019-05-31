package com.devundefined.pokemontestapp.domain

import com.devundefined.pokemontestapp.domain.models.Pokemon

interface PokemonRepository {
    fun getById(id: Int): Pokemon?
    fun save(pokemons: List<Pokemon>)
    fun getAll(): List<Pokemon>
}