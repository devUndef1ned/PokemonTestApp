package com.devundefined.pokemontestapp.presentation.pokemoninfo

import com.devundefined.pokemontestapp.domain.services.PokemonLoadService
import com.devundefined.pokemontestapp.presentation.load
import io.reactivex.disposables.CompositeDisposable

class PokemonInfoPresenterImpl(private val dataLoadService: PokemonLoadService) : PokemonInfoPresenter {

    private var view: PokemonInfoView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: PokemonInfoView) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.dispose()
        view = null
    }

    override fun loadPokemon(id: Int) {
        view?.showLoading()
        compositeDisposable.add(load { dataLoadService.loadPokemon(id) }
            .subscribe { pokemon -> view?.showPokemon(pokemon) })
    }
}