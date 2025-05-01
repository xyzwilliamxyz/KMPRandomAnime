package com.example.kmprandomanime.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

interface CoroutineDispatcherProvider {
    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher

    fun main(): CoroutineDispatcher
}

class CoroutineDispatcherProviderImpl : CoroutineDispatcherProvider {
    override fun io() = Dispatchers.IO

    override fun default() = Dispatchers.Default

    override fun main() = Dispatchers.Main
}