package com.devundefined.pokemontestapp.infrastructure.persistance

import com.devundefined.pokemontestapp.domain.models.Pokemon

val toEntity: (Pokemon) -> PokemonEntity = { pokemon ->
    with(pokemon) { PokemonEntity(id, name, photoUrl, height, weight, arrayListOf(*types.toTypedArray())) }
}

val toModel: (PokemonEntity) -> Pokemon = { entity ->
    with(entity) { Pokemon(id, name, photoUrl, height, weight, types) }
}