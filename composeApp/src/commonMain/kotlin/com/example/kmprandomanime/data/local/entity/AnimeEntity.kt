package com.example.kmprandomanime.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Entity(tableName = "anime")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val title: String,
    val imageUrl: String,
    val score: String,
    val mediaType: String,
    val genres: List<String>,
    val rank: String,
    val popularity: String,
    val members: String,
    val favorites: String,
    val airingStatus: String,
    val episodes: String,
    val duration: String,
    val summary: String,
    val airingPeriod: String,
    val createdAt: Long = Clock.System.now().toEpochMilliseconds()
)