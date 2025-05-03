package com.example.kmprandomanime.testutils

import com.example.kmprandomanime.core.CoroutineDispatcherProvider
import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProviderTestImpl : CoroutineDispatcherProvider {
    override fun io() = Dispatchers.Unconfined

    override fun default() = Dispatchers.Unconfined

    override fun main() = Dispatchers.Unconfined
}
