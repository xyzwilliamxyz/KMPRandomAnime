package com.example.kmprandomanime.data.datasource.config

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kmprandomanime.data.local.db.AppDatabase

fun getDatabaseBuilderAndroid(ctx: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("kmpra_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}