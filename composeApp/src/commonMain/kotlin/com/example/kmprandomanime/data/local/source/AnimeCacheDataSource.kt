package com.example.kmprandomanime.data.local.source

import com.example.kmprandomanime.data.local.db.AnimeDao
import com.example.kmprandomanime.data.local.entity.AnimeEntity

internal interface AnimeCacheDataSource {
    suspend fun getAllAnime(): List<AnimeEntity>
    suspend fun getAnimeById(id: Int): AnimeEntity?
    suspend fun insertAnime(anime: AnimeEntity)
    suspend fun deleteAllAnime()
}

internal class RoomAnimeCacheDataSourceImpl(
    private val animeDao: AnimeDao,
) : AnimeCacheDataSource {
    override suspend fun getAllAnime(): List<AnimeEntity> {
        return animeDao.getAllAnime()
    }

    override suspend fun getAnimeById(id: Int): AnimeEntity? {
        return animeDao.getAnimeById(id)
    }

    override suspend fun insertAnime(anime: AnimeEntity) {
        animeDao.insertAnime(anime)
    }

    override suspend fun deleteAllAnime() {
        animeDao.deleteAllAnime()
    }
}