package com.example.kmprandomanime.data.remote.config

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val TIMEOUT_MILLIS = 60000L

internal class HttpClientProvider(
    private val apiBaseUrl: ApiBaseUrl,
    private val clientEngine: HttpClientEngine
) {
    fun provide(): HttpClient {
        return HttpClient(clientEngine) {
            defaultRequest {
                url {
                    host = apiBaseUrl.host
                    url { protocol = URLProtocol.HTTPS }
                    contentType(ContentType.Application.Json)
                }
            }
            install(HttpTimeout) {
                requestTimeoutMillis = TIMEOUT_MILLIS
                connectTimeoutMillis = TIMEOUT_MILLIS
                socketTimeoutMillis = TIMEOUT_MILLIS
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
}