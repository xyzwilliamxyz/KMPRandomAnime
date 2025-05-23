package com.example.kmprandomanime.ui.details

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class AnimeDetailsScreenSnapshotTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
    )

    @Test
    fun `test AnimeDetailsScreen with light theme`() {
        paparazzi.snapshot {
            CompositionLocalProvider(LocalInspectionMode provides true) {
                AnimeDetailsScreen_Preview()
            }
        }
    }

    @Test
    fun `test AnimeDetailsScreen with dark theme`() {
        paparazzi.snapshot {
            CompositionLocalProvider(LocalInspectionMode provides true) {
                AnimeDetailsScreen_Preview(darkTheme = true)
            }
        }
    }
}
