package com.example.kmprandomanime.data.local.mapper

import com.example.kmprandomanime.data.local.entity.AnimeEntity
import com.example.kmprandomanime.domain.model.AnimeEntry

internal fun AnimeEntry.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        title = title,
        imageUrl = imageUrl,
        score = score,
        mediaType = mediaType,
        genres = genres,
        rank = rank,
        popularity = popularity,
        members = members,
        favorites = favorites,
        airingStatus = airingStatus,
        episodes = episodes,
        duration = duration,
        summary = summary,
        airingPeriod = airingPeriod,
    )
}

internal fun AnimeEntity.toAnimeEntry(): AnimeEntry {
    return AnimeEntry(
        id = id,
        title = title,
        imageUrl = imageUrl,
        score = score,
        mediaType = mediaType,
        genres = genres,
        rank = rank,
        popularity = popularity,
        members = members,
        favorites = favorites,
        airingStatus = airingStatus,
        episodes = episodes,
        duration = duration,
        summary = summary,
        airingPeriod = airingPeriod,
    )
}
