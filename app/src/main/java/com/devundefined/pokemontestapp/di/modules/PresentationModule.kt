package com.devundefined.pokemontestapp.di.modules

import com.devundefined.pokemontestapp.domain.services.PokemonDataProviderService
import com.devundefined.pokemontestapp.domain.services.PokemonLoadService
import com.devundefined.pokemontestapp.presentation.pokemonlist.PokemonListPresenter
import com.devundefined.pokemontestapp.presentation.pokemonlist.PokemonListPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

    @Provides
    @Singleton
    fun providePokemonListPresenter(loadService: PokemonLoadService, dataProviderService: PokemonDataProviderService): PokemonListPresenter
            = PokemonListPresenterImpl(loadService, dataProviderService)
}