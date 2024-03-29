package com.devundefined.pokemontestapp.infrastructure.persistance

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type
import java.util.ArrayList

class Converters {
    @TypeConverter
    fun fromTimestamp(value: String): ArrayList<String>? {
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson<ArrayList<String>>(value, listType)
    }

    @TypeConverter
    fun arrayListToString(list: ArrayList<String>): String {
        return Gson().toJson(list)
    }
}
