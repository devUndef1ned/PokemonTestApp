package com.devundefined.pokemontestapp.infrastructure.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devundefined.pokemontestapp.domain.models.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity")
    fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE id = :id")
    fun findById(id: Int): PokemonEntity?

    @Insert
    fun insertAll(pokemons: List<PokemonEntity>)

    @Insert
    fun insert(pokemon: PokemonEntity)
}