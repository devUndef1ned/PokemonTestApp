package com.devundefined.pokemontestapp.presentation.pokemonlist

import com.devundefined.pokemontestapp.domain.models.Pokemon

interface PokemonListView {

    fun show(pokemons: List<Pokemon>)

    fun showLoading()
}