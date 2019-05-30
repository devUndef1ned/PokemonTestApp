package com.devundefined.pokemontestapp.di

import com.devundefined.pokemontestapp.di.modules.InfrastructureModule
import dagger.Component

@Component(modules = [InfrastructureModule::class])
interface AppComponent {

}