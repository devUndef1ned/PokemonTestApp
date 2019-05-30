package com.devundefined.pokemontestapp.domain.services

import com.devundefined.pokemontestapp.domain.models.Pokemon
import com.devundefined.pokemontestapp.infrastructure.backend.PokemonInfoApi
import com.devundefined.pokemontestapp.infrastructure.backend.dto.PokemonDto
import com.devundefined.pokemontestapp.infrastructure.backend.dto.PokemonInfoDto

interface PokemonLoadService {
    fun loadPokemons(): List<Pokemon>
}

class PokemonLoadServiceImpl(private val pokemonApi: PokemonInfoApi) : PokemonLoadService {

    val getId: (PokemonInfoDto) -> Int = { pokemonInfoDto ->
        pokemonInfoDto.url.let { string ->
            val indexOfLastDash = string.indexOfLast { it == '/' }
            val cutString = string.substring(0, indexOfLastDash - 1)
            val indexOfPrelastDash = cutString.indexOfLast { it == '/' }
            cutString.substring(indexOfPrelastDash, cutString.length - 1).toInt()
        }
    }

    val toModel: (PokemonDto) -> Pokemon = { pokemonDto ->
        with(pokemonDto) { Pokemon(id, name, sprite.url, height, weight, listOf(*types.map { it.typeName.name }.toTypedArray())) }

    }

    override fun loadPokemons(): List<Pokemon> {
        val result = arrayListOf<Pokemon>()
        pokemonApi.getPokemonInfoList().results.map(getId).forEach { id ->
            result.add(toModel(pokemonApi.getPokemon(id)))
        }

        return result
    }
}