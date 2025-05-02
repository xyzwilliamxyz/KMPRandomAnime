package com.example.kmprandomanime.ui.list

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class RandomAnimeListScreenSnapshotTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
    )

    @Test
    fun testMyComposable() {
        paparazzi.snapshot {
            CompositionLocalProvider(LocalInspectionMode provides true) {
                RandomAnimeListScreen_Preview()
            }
        }
    }
}
