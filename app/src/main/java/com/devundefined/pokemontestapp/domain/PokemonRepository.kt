package com.devundefined.pokemontestapp.domain

import com.devundefined.pokemontestapp.domain.models.Pokemon

interface PokemonRepository {
    fun getById(id: Int): Pokemon?
    fun save(pokemons: Collection<Pokemon>)
    fun getAll(): Collection<Pokemon>
}