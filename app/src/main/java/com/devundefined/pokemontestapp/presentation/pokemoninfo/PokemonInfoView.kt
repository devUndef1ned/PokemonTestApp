package com.devundefined.pokemontestapp.presentation.pokemoninfo

import com.devundefined.pokemontestapp.domain.models.Pokemon

interface PokemonInfoView {

    fun showLoading()

    fun showPokemon(pokemon: Pokemon)
}