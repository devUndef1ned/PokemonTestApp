package com.devundefined.pokemontestapp.domain.models

import java.io.Serializable

data class Pokemon(val id: Int, val name: String, val photoUrl: String?, val height: Int?, val weight: Int?, val types: List<String> = listOf()) : Serializable