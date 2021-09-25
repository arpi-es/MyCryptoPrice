package com.example.cryptoprice.data.local

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromPriceFloat(value: Float?): String {
        return value.toString()
    }

    @TypeConverter
    fun toPriceFloat(value: String) : Float{
        return value.toFloat()
    }
}