package com.example.kmprandomanime.preview

import com.example.kmprandomanime.domain.model.AnimeEntry

internal object ComposePreviewData {
    fun animeEntry() = AnimeEntry(
        id = 1,
        title = "Bleach",
        imageUrl = "",
        score = "8.5",
        mediaType = "TV",
        genres = listOf(),
        rank = "1244",
        popularity = "12",
        members = "14000",
        favorites = "5600",
        airingStatus = "Finished Airing",
        episodes = "240",
        duration = "19 min",
        summary = "The \\\"Chibi Godzilla\\\" project was launched to celebrate the 65th anniversary of Toho's Godzilla franchise.",
        airingPeriod = "Jul 15, 2020 to Sep 30, 2020",
    )
}