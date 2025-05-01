package com.example.kmprandomanime.ui.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.img_debug
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun debugPlaceholder(debugPreview: DrawableResource = Res.drawable.img_debug) =
    if (LocalInspectionMode.current) {
        painterResource(debugPreview)
    } else {
        null
    }
