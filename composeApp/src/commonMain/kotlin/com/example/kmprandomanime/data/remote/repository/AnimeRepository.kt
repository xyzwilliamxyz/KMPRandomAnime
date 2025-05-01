package com.example.kmprandomanime.data.remote.repository

import com.example.kmprandomanime.data.remote.api.AnimeApi
import com.example.kmprandomanime.data.remote.response.RandomAnimeResponse

internal interface AnimeRepository {
    suspend fun getRandomAnime(): RandomAnimeResponse
}

internal class AnimeRemoteRepositoryImpl(
    private val animeApi: AnimeApi,
) : AnimeRepository {
    override suspend fun getRandomAnime(): RandomAnimeResponse {
        return animeApi.getRandomAnime()
    }
}
