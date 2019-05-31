package com.devundefined.pokemontestapp.presentation.pokemonlist

import com.devundefined.pokemontestapp.domain.models.Pokemon
import com.devundefined.pokemontestapp.domain.services.PokemonDataProviderService
import com.devundefined.pokemontestapp.domain.services.PokemonLoadService
import com.devundefined.pokemontestapp.presentation.load
import com.devundefined.pokemontestapp.presentation.perform
import io.reactivex.disposables.CompositeDisposable

class PokemonListPresenterImpl(private val loadService: PokemonLoadService,
                               private val providerService: PokemonDataProviderService) : PokemonListPresenter {

    private var view: PokemonListView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: PokemonListView) {
        this.view = view
        onViewAttached()
    }

    private fun onViewAttached() {
        compositeDisposable.addAll(
            load { providerService.getData() }
                .subscribe { pokemons -> onPokemonsLoaded(pokemons) }
        )
    }

    private fun onPokemonsLoaded(pokemons: List<Pokemon>) {
        if (pokemons.isEmpty()) {
            compositeDisposable.add(
                perform { loadService.loadPokemons() }
                    .subscribe()
            )
        } else {
            view?.show(pokemons)
        }
    }

    override fun detachView() {
        view = null
        compositeDisposable.dispose()
    }
}