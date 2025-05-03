package com.example.kmprandomanime.data.remote.api

import com.example.kmprandomanime.data.remote.response.RandomAnimeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class AnimeApi(
    private val client: HttpClient,
) {
    suspend fun getRandomAnime(): Result<RandomAnimeResponse> = runCatching {
        client.get("/v4/random/anime").body()
    }
}
