package com.example.kmprandomanime.domain.interactor

import com.example.kmprandomanime.data.remote.mapper.toAnimeEntry
import com.example.kmprandomanime.domain.model.AnimeEntry
import com.example.kmprandomanime.data.remote.repository.AnimeRepository

private const val EXCLUDED_GENRES = "Hentai, Ecchi, Yaoi, Yuri, Shoujo Ai, Shounen Ai"

internal interface GetRandomAnimeInteractor {
    suspend operator fun invoke(): AnimeEntry
}

internal class GetRandomAnimeInteractorImpl(
    private val animeRepository: AnimeRepository
) : GetRandomAnimeInteractor {

    override suspend operator fun invoke(): AnimeEntry {
        var result = animeRepository
            .getRandomAnime()
            .toAnimeEntry()

        // The Api doesn't provide a NSFW filter, so we need to filter it out manually
        while (result.genres.any { it in EXCLUDED_GENRES }) {
            result = animeRepository
                .getRandomAnime()
                .toAnimeEntry()
        }

        return result
    }
}