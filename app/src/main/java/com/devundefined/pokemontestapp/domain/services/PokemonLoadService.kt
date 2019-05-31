package com.devundefined.pokemontestapp.domain.services

import com.devundefined.pokemontestapp.domain.PokemonRepository
import com.devundefined.pokemontestapp.domain.models.Pokemon
import com.devundefined.pokemontestapp.infrastructure.backend.PokemonInfoApi
import com.devundefined.pokemontestapp.infrastructure.backend.dto.PokemonDto
import com.devundefined.pokemontestapp.infrastructure.backend.dto.PokemonInfoDto

interface PokemonLoadService {
    fun loadPokemons(): List<Pokemon>
    fun loadPokemon(id: Int): Pokemon
}

class PokemonLoadServiceImpl(private val pokemonApi: PokemonInfoApi,
                             private val pokemonRepository: PokemonRepository) : PokemonLoadService {

    val getId: (PokemonInfoDto) -> Int = { pokemonInfoDto ->
        pokemonInfoDto.url.let { string ->
            val indexOfLastDash = string.indexOfLast { it == '/' }
            val cutString = string.substring(0, indexOfLastDash)
            val indexOfPrelastDash = cutString.indexOfLast { it == '/' }
            cutString.substring(indexOfPrelastDash + 1, cutString.length).toInt()
        }
    }

    val toModel: (PokemonDto) -> Pokemon = { pokemonDto ->
        with(pokemonDto) { Pokemon(id, name, sprite.url, height, weight, listOf(*types.map { it.typeName.name }.toTypedArray())) }

    }

    override fun loadPokemon(id: Int): Pokemon {
        return pokemonApi.getPokemon(id).let(toModel).apply { pokemonRepository.save(this) }
    }

    override fun loadPokemons(): List<Pokemon> {
        return pokemonApi.getPokemonInfoList().results
            .map { pokemonInfoDto -> Pokemon(getId(pokemonInfoDto), pokemonInfoDto.name, null, null, null)  }
            .let { result -> result.sortedBy(Pokemon::id); pokemonRepository.save(result); result }
    }
}