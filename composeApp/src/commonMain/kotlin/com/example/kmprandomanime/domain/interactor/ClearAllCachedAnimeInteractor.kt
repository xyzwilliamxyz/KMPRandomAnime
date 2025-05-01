package com.example.kmprandomanime.domain.interactor

import com.example.kmprandomanime.data.local.source.AnimeCacheDataSource

internal interface ClearAllCachedAnimeInteractor {
    suspend operator fun invoke()
}

internal class ClearAllCachedAnimeInteractorImpl(
    private val animeCacheDataSource: AnimeCacheDataSource,
) : ClearAllCachedAnimeInteractor {
    override suspend operator fun invoke() {
        animeCacheDataSource.deleteAllAnime()
    }
}