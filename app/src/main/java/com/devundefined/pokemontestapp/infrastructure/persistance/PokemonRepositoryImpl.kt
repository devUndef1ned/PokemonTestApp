package com.devundefined.pokemontestapp.infrastructure.persistance

import com.devundefined.pokemontestapp.domain.PokemonRepository
import com.devundefined.pokemontestapp.domain.models.Pokemon

class PokemonRepositoryImpl(private val pokemonDao: PokemonDao) : PokemonRepository {
    override fun getById(id: Int): Pokemon? {
        return pokemonDao.findById(id)?.let(toModel)
    }

    override fun save(pokemons: Collection<Pokemon>) {
        return pokemonDao.insertAll(pokemons.mapTo(mutableListOf(), toEntity))
    }

    override fun getAll(): Collection<Pokemon> {
        return pokemonDao.getAll().map(toModel)
    }
}