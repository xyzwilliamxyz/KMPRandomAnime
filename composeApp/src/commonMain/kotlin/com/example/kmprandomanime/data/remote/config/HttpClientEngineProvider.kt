package com.example.kmprandomanime.data.remote.config

import io.ktor.client.engine.HttpClientEngine

internal expect object HttpClientEngineProvider {
    fun provide(): HttpClientEngine
}