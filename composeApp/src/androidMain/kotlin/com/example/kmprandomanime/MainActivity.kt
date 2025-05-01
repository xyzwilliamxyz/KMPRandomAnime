package com.example.kmprandomanime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            val view = LocalView.current
            val isSystemInDarkTheme = isSystemInDarkTheme()
            val insets = WindowCompat.getInsetsController(window, view)

            SideEffect {
                insets.isAppearanceLightStatusBars = isSystemInDarkTheme
                insets.isAppearanceLightNavigationBars = isSystemInDarkTheme
            }
            App()
        }
    }
}