package com.example.kmprandomanime.domain.interactor

import com.example.kmprandomanime.data.local.mapper.toAnimeEntry
import com.example.kmprandomanime.data.local.source.AnimeCacheDataSource
import com.example.kmprandomanime.domain.model.AnimeEntry

internal interface GetAllCachedAnimeInteractor {
    suspend operator fun invoke(): List<AnimeEntry>
}

internal class GetAllCachedAnimeInteractorImpl(
    private val animeCacheDataSource: AnimeCacheDataSource,
) : GetAllCachedAnimeInteractor {
    override suspend operator fun invoke(): List<AnimeEntry> {
        return animeCacheDataSource
            .getAllAnime()
            .map { it.toAnimeEntry() }
    }
}
