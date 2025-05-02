package com.example.kmprandomanime.ui.core.theme.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Icons.Star: ImageVector
    get() = ImageVector.Builder(
        name = "Star",
        defaultWidth = 12.dp,
        defaultHeight = 12.dp,
        viewportWidth = 12f,
        viewportHeight = 12f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFF46464F)),
            pathFillType = PathFillType.NonZero,
        ) {
            moveTo(7.215f, 5f)
            lineTo(6f, 1f)
            lineTo(4.785f, 5f)
            lineTo(1f, 5f)
            lineTo(4.09f, 7.205f)
            lineTo(2.915f, 11f)
            lineTo(6f, 8.655f)
            lineTo(9.09f, 11f)
            lineTo(7.915f, 7.205f)
            lineTo(11f, 5f)
            lineTo(7.215f, 5f)
            close()
        }
    }.build()
