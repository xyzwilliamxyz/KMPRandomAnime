package com.example.kmprandomanime

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform