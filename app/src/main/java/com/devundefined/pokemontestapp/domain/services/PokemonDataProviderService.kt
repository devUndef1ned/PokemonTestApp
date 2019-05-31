package com.devundefined.pokemontestapp.domain.services

import com.devundefined.pokemontestapp.domain.PokemonRepository
import com.devundefined.pokemontestapp.domain.models.Pokemon

interface PokemonDataProviderService {

    fun getData(): List<Pokemon>

    @Throws(PokemonNotFoundException::class)
    fun getPokemonById(id: Int): Pokemon
}

class PokemonNotFoundException : Exception()

class PokemonDataProviderServiceImpl(private val pokemonRepository: PokemonRepository) : PokemonDataProviderService {

    override fun getData(): List<Pokemon> {
        return pokemonRepository.getAll()
    }

    override fun getPokemonById(id: Int): Pokemon {
        return pokemonRepository.getById(id)?: throw PokemonNotFoundException()
    }
}