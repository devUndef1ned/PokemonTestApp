package com.devundefined.pokemontestapp.infrastructure.backend.dto

import com.google.gson.annotations.SerializedName

class PokemonDto(@SerializedName("id") val id: Int,
                 @SerializedName("name") val name: String,
                 @SerializedName("sprites") val sprite: SpriteDto,
                 @SerializedName("height") val height: Int,
                 @SerializedName("weight") val weight: Int,
                 @SerializedName("types") val types: TypesDto)

class SpriteDto(@SerializedName("front_default") val url: String?)
class TypesDto : ArrayList<TypeDto>()
class TypeDto(@SerializedName("slot") val slot: Int, @SerializedName("type") val typeName: TypeNameDto)
class TypeNameDto(@SerializedName("name") val name: String)