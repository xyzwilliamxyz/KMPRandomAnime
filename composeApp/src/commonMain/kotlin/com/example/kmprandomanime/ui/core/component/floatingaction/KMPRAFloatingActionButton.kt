package com.example.kmprandomanime.ui.core.component.floatingaction

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
internal fun KMPRAFloatingActionButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        onClick = onClick
    ) {
        Icon(icon, contentDescription = icon.name)
    }
}

