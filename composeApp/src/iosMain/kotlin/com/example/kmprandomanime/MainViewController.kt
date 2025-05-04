package com.example.kmprandomanime

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmprandomanime.di.appModule
import com.example.kmprandomanime.di.dataModule
import com.example.kmprandomanime.di.interactorModule
import com.example.kmprandomanime.di.networkModule
import com.example.kmprandomanime.di.platformModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(
                appModule,
                dataModule,
                networkModule,
                interactorModule,
                platformModule(),
            )
        }
    }
) {
    App()
}
