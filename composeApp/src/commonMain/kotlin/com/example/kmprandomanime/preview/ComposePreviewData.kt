package com.example.kmprandomanime.preview

import com.example.kmprandomanime.domain.model.AnimeEntry

internal object ComposePreviewData {
    fun animeEntry() = AnimeEntry(
        id = 1,
        title = "Zom 100: Zombie ni Naru made ni Shitai 100 no Koto",
        imageUrl = "https://cdn.myanimelist.net/images/anime/1384/136408l.jpg",
        score = "8.25",
        mediaType = "TV",
        genres = listOf("Action", "Adventure", "Adult", "Sci-Fi"),
        rank = "127",
        popularity = "1234567",
        members = "1237140",
        favorites = "43293",
        airingStatus = "Finished Airing",
        episodes = "13",
        duration = "23 min",
        summary = "After graduating from a top university with an impressive extracurricular record in the rugby club, Akira Tendou has nailed every step of the way to securing his dream job. On top of that, a beautiful and kind co-worker always brightens his day in the office! Life seems to be going very well for Akira until he slowly realizes that sleepless nights and brutal work are his new reality.\n\nDue to three years of mind-numbing labor in an exploitative company, Akira is unable to recognize the tired, unaccomplished person he has become. On track to losing all passion in life like several of his overworked colleagues, Akira finds his saving grace in the most unexpected way possible—the breakout of a zombie apocalypse.\n\nWith the free time he finally has, Akira decides to complete a bucket list of a hundred things he wants to do before he eventually gets turned into a zombie. Although he is surrounded by the dead, Akira has never felt more alive!\n\n[Written by MAL Rewrite]",
        airingPeriod = "Jul 15, 2023 to Sep 30, 2023",
    )
}
