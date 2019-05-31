package com.devundefined.pokemontestapp.di.modules

import com.devundefined.pokemontestapp.domain.PokemonRepository
import com.devundefined.pokemontestapp.domain.services.PokemonDataProviderService
import com.devundefined.pokemontestapp.domain.services.PokemonDataProviderServiceImpl
import com.devundefined.pokemontestapp.domain.services.PokemonLoadService
import com.devundefined.pokemontestapp.domain.services.PokemonLoadServiceImpl
import com.devundefined.pokemontestapp.infrastructure.backend.PokemonInfoApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideLoadService(pokemonInfoApi: PokemonInfoApi): PokemonLoadService = PokemonLoadServiceImpl(pokemonInfoApi)

    @Provides
    @Singleton
    fun provideDataProviderService(pokemonRepository: PokemonRepository): PokemonDataProviderService =
        PokemonDataProviderServiceImpl(pokemonRepository)
}