package com.devundefined.pokemontestapp.di

import com.devundefined.pokemontestapp.di.modules.ContextModule
import com.devundefined.pokemontestapp.di.modules.DomainModule
import com.devundefined.pokemontestapp.di.modules.InfrastructureModule
import com.devundefined.pokemontestapp.di.modules.PresentationModule
import com.devundefined.pokemontestapp.presentation.pokemonlist.PokemonListPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [InfrastructureModule::class, DomainModule::class, PresentationModule::class, ContextModule::class])
@Singleton
interface AppComponent {

    fun listPresenter(): PokemonListPresenter
}