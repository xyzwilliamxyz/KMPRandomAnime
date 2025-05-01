package com.example.kmprandomanime.domain.interactor

import com.example.kmprandomanime.data.local.mapper.toAnimeEntry
import com.example.kmprandomanime.data.local.source.AnimeCacheDataSource
import com.example.kmprandomanime.domain.model.AnimeEntry

internal interface GetAnimeByIdInteractor {
    suspend operator fun invoke(id: Int): AnimeEntry?
}

internal class GetAnimeByIdInteractorImpl(
    private val animeCacheDataSource: AnimeCacheDataSource,
) : GetAnimeByIdInteractor {
    override suspend operator fun invoke(id: Int): AnimeEntry? {
        return animeCacheDataSource.getAnimeById(id)?.toAnimeEntry()
    }
}
