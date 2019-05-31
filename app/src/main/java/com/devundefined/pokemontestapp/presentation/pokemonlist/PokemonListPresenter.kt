package com.devundefined.pokemontestapp.presentation.pokemonlist

interface PokemonListPresenter {

    fun attachView(view: PokemonListView)
    fun detachView()
}