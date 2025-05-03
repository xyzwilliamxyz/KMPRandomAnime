package com.example.kmprandomanime.domain.interactor

import com.example.kmprandomanime.data.remote.mapper.toAnimeEntry
import com.example.kmprandomanime.data.remote.repository.AnimeRepository
import com.example.kmprandomanime.domain.model.AnimeEntry

private const val EXCLUDED_GENRES = "Hentai, Ecchi, Yaoi, Yuri, Shoujo Ai, Shounen Ai"
private const val MAX_ATTEMPTS = 10

internal interface GetRandomAnimeInteractor {
    suspend operator fun invoke(): AnimeEntry
}

internal class GetRandomAnimeInteractorImpl(
    private val animeRepository: AnimeRepository,
) : GetRandomAnimeInteractor {

    override suspend operator fun invoke(): AnimeEntry {
        repeat(MAX_ATTEMPTS) {
            val result = animeRepository.getRandomAnime()
                .mapCatching { it.toAnimeEntry() }
                .getOrElse { throw AnimeFetchException("Failed to fetch anime", it) }

            // The Api doesn't provide a NSFW filter, so we need to filter it out manually
            if (result.genres.none { it in EXCLUDED_GENRES }) {
                return result
            }
        }
        throw NoSafeAnimeFoundException("Failed to find a safe anime after $MAX_ATTEMPTS attempts")
    }
}

class AnimeFetchException(message: String, cause: Throwable) : Exception(message, cause)
class NoSafeAnimeFoundException(message: String) : Exception(message)
