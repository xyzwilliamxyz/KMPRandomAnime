package com.example.kmprandomanime.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kmprandomanime.data.local.entity.AnimeEntity

@Dao
interface AnimeDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAnime(anime: AnimeEntity)

    @Query("SELECT * FROM anime WHERE id = :id")
    suspend fun getAnimeById(id: Int): AnimeEntity?

    @Query("SELECT * FROM anime ORDER BY createdAt")
    suspend fun getAllAnime(): List<AnimeEntity>

    @Query("DELETE FROM anime")
    suspend fun deleteAllAnime()
}