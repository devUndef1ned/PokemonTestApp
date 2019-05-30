package com.devundefined.pokemontestapp.di.modules

import android.content.Context
import androidx.room.Room
import com.devundefined.pokemontestapp.domain.PokemonRepository
import com.devundefined.pokemontestapp.infrastructure.backend.PokemonInfoApi
import com.devundefined.pokemontestapp.infrastructure.persistance.PokemonDao
import com.devundefined.pokemontestapp.infrastructure.persistance.PokemonDatabase
import com.devundefined.pokemontestapp.infrastructure.persistance.PokemonRepositoryImpl
import com.jaredsburrows.retrofit2.adapter.synchronous.SynchronousCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class InfrastructureModule {

    @Provides
    @Singleton
    fun providePokemonApi(retrofit: Retrofit): PokemonInfoApi {
        return retrofit.create(PokemonInfoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): PokemonDatabase {
        return Room.databaseBuilder(context, PokemonDatabase::class.java, "pokemon_database").build()
    }

    @Provides
    @Singleton
    fun provideDao(pokemonDatabase: PokemonDatabase) = pokemonDatabase.pokemonDao()

    @Provides
    @Singleton
    fun provideRepository(dao: PokemonDao): PokemonRepository = PokemonRepositoryImpl(dao)
}