package com.example.kmprandomanime.data.local.db

import androidx.room.TypeConverter

internal class GenreTypeConverter {
    @TypeConverter
    fun fromGenreList(genres: List<String>): String {
        return genres.joinToString(separator = ",")
    }

    @TypeConverter
    fun toGenreList(data: String): List<String> {
        return if (data.isBlank()) emptyList() else data.split(",")
    }
}
