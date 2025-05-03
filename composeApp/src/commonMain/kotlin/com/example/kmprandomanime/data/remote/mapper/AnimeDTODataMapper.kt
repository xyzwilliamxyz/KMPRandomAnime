package com.example.kmprandomanime.data.remote.mapper

import com.example.kmprandomanime.data.remote.response.RandomAnimeResponse
import com.example.kmprandomanime.domain.model.AnimeEntry

internal fun RandomAnimeResponse.toAnimeEntry(): AnimeEntry {
    return AnimeEntry(
        id = data?.malId ?: 0,
        title = data?.title.orEmpty(),
        imageUrl = data?.images?.webp?.imageUrl.orEmpty(),
        score = data?.score?.toString() ?: "N/A",
        mediaType = data?.type.orEmpty(),
        genres = data?.genres?.mapNotNull { it?.name } ?: emptyList(),
        rank = data?.rank?.toString() ?: "N/A",
        popularity = data?.popularity?.toString() ?: "N/A",
        members = data?.members?.toString() ?: "N/A",
        favorites = data?.favorites?.toString() ?: "N/A",
        airingStatus = data?.status.orEmpty(),
        episodes = data?.episodes?.toString() ?: "?",
        duration = data?.duration.orEmpty(),
        summary = data?.synopsis.orEmpty(),
        airingPeriod = data?.aired?.string.orEmpty(),
    )
}
