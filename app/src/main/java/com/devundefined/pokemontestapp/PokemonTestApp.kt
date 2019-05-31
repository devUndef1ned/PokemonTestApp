package com.devundefined.pokemontestapp

import android.app.Application
import com.devundefined.pokemontestapp.di.AppComponent
import com.devundefined.pokemontestapp.di.DaggerAppComponent
import com.devundefined.pokemontestapp.di.modules.ContextModule

class PokemonTestApp : Application() {

    companion object {
        lateinit var INSTANCE: PokemonTestApp
            private set
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initDi()
    }

    private fun initDi() {
        appComponent = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }
}