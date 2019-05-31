package com.devundefined.pokemontestapp.infrastructure.persistance

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey var id: Int,
    var name: String,
    var photoUrl: String?,
    var height: Int?,
    var weight: Int?,
    var types: ArrayList<String>
)