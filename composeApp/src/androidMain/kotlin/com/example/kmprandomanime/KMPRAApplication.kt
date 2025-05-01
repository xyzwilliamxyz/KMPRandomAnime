package com.example.kmprandomanime

import android.app.Application
import com.example.kmprandomanime.di.platformModule
import com.example.kmprandomanime.di.appModule
import com.example.kmprandomanime.di.dataModule
import com.example.kmprandomanime.di.interactorModule
import com.example.kmprandomanime.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

class KMPRAApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KMPRAApplication)
            modules(
                appModule,
                dataModule,
                networkModule,
                interactorModule,
                platformModule()
            )
        }
    }
}