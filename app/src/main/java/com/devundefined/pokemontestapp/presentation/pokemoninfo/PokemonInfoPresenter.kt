package com.devundefined.pokemontestapp.presentation.pokemoninfo

interface PokemonInfoPresenter {

    fun attachView(view: PokemonInfoView)

    fun detachView()

    fun loadPokemon(id: Int)
}