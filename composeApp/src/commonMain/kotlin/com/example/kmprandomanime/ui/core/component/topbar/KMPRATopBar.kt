package com.example.kmprandomanime.ui.core.component.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.kmprandomanime.ui.core.theme.KMPRATheme
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.back_content_description
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun KMPRATopBar(
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    onBackClick: (() -> Unit)? = null,
) {
    TopAppBar(
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(Res.string.back_content_description))
                }
            }
        },
        title = { Text(title) },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

@Preview
@Composable
private fun KMPRATopBar_Preview() {
    KMPRATheme {
        KMPRATopBar(
            onBackClick = {},
            title = "Top Bar Title",
            actions = {
                IconButton(onClick = { /* Handle search */ }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            },
        )
    }
}
