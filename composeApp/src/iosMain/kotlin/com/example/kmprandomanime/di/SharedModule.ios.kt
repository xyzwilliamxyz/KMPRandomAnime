package com.example.kmprandomanime.di

import androidx.room.RoomDatabase
import com.example.kmprandomanime.data.local.db.AppDatabase
import com.example.kmprandomanime.data.datasource.config.getDatabaseBuilderIos
import org.koin.dsl.module

actual fun platformModule() = module {
    single<RoomDatabase.Builder<AppDatabase>> {
        getDatabaseBuilderIos()
    }
}