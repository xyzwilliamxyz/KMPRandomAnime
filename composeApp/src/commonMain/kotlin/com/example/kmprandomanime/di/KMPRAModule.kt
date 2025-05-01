package com.example.kmprandomanime.di

import com.example.kmprandomanime.core.CoroutineDispatcherProvider
import com.example.kmprandomanime.core.CoroutineDispatcherProviderImpl
import com.example.kmprandomanime.core.StringProvider
import com.example.kmprandomanime.data.local.source.AnimeCacheDataSource
import com.example.kmprandomanime.data.local.db.AppDatabase
import com.example.kmprandomanime.data.local.db.getRoomDatabase
import com.example.kmprandomanime.data.local.source.RoomAnimeCacheDataSourceImpl
import com.example.kmprandomanime.data.remote.repository.AnimeRepository
import com.example.kmprandomanime.domain.interactor.ClearAllCachedAnimeInteractor
import com.example.kmprandomanime.domain.interactor.GetAllCachedAnimeInteractor
import com.example.kmprandomanime.domain.interactor.GetAnimeByIdInteractor
import com.example.kmprandomanime.domain.interactor.GetRandomAnimeInteractor
import com.example.kmprandomanime.domain.interactor.SaveAnimeToCacheInteractor
import com.example.kmprandomanime.data.remote.api.AnimeApi
import com.example.kmprandomanime.data.remote.config.ApiBaseUrl
import com.example.kmprandomanime.data.remote.config.HttpClientEngineProvider
import com.example.kmprandomanime.data.remote.config.HttpClientProvider
import com.example.kmprandomanime.data.remote.repository.AnimeRemoteRepositoryImpl
import com.example.kmprandomanime.domain.interactor.ClearAllCachedAnimeInteractorImpl
import com.example.kmprandomanime.domain.interactor.GetAllCachedAnimeInteractorImpl
import com.example.kmprandomanime.domain.interactor.GetAnimeByIdInteractorImpl
import com.example.kmprandomanime.domain.interactor.GetRandomAnimeInteractorImpl
import com.example.kmprandomanime.domain.interactor.SaveAnimeToCacheInteractorImpl
import com.example.kmprandomanime.ui.details.AnimeDetailsViewModel
import com.example.kmprandomanime.ui.list.RandomAnimeListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect fun platformModule(): Module

val appModule = module {
    factoryOf(::CoroutineDispatcherProviderImpl).bind(CoroutineDispatcherProvider::class)
    factoryOf(::StringProvider)

    viewModelOf(::RandomAnimeListViewModel)
    viewModelOf(::AnimeDetailsViewModel)
}

val dataModule = module {
    // remote
    singleOf(::AnimeApi)
    factoryOf(::AnimeRemoteRepositoryImpl).bind(AnimeRepository::class)

    // database
    single { getRoomDatabase(get()) }
    factoryOf(AppDatabase::animeDao)
    factoryOf(::RoomAnimeCacheDataSourceImpl).bind(AnimeCacheDataSource::class)
}

val networkModule = module {
    single { ApiBaseUrl("api.jikan.moe") }
    singleOf(HttpClientEngineProvider::provide)
    singleOf(::HttpClientProvider)
    singleOf(HttpClientProvider::provide)
}

val interactorModule = module {
    factoryOf(::GetRandomAnimeInteractorImpl).bind(GetRandomAnimeInteractor::class)
    factoryOf(::GetAllCachedAnimeInteractorImpl).bind(GetAllCachedAnimeInteractor::class)
    factoryOf(::SaveAnimeToCacheInteractorImpl).bind(SaveAnimeToCacheInteractor::class)
    factoryOf(::ClearAllCachedAnimeInteractorImpl).bind(ClearAllCachedAnimeInteractor::class)
    factoryOf(::GetAnimeByIdInteractorImpl).bind(GetAnimeByIdInteractor::class)
}