package com.example.kmprandomanime.domain.interactor

import com.example.kmprandomanime.data.local.mapper.toAnimeEntity
import com.example.kmprandomanime.data.local.source.AnimeCacheDataSource
import com.example.kmprandomanime.domain.model.AnimeEntry

internal interface SaveAnimeToCacheInteractor {
    suspend operator fun invoke(animeEntry: AnimeEntry)
}

internal class SaveAnimeToCacheInteractorImpl(
    private val animeCacheDataSource: AnimeCacheDataSource,
) : SaveAnimeToCacheInteractor {
    override suspend operator fun invoke(animeEntry: AnimeEntry) {
        animeCacheDataSource
            .insertAnime(animeEntry.toAnimeEntity())
    }
}
