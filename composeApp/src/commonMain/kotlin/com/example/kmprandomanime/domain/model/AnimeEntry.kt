package com.example.kmprandomanime.domain.model

data class AnimeEntry(
    val id: Int,
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
)