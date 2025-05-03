package com.example.kmprandomanime.ui.core.component.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import coil3.compose.SubcomposeAsyncImage
import com.example.kmprandomanime.ui.core.component.loading.LoadingIndicator
import com.example.kmprandomanime.ui.core.theme.Dimension
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun AnimeAsyncImage(imageUrl: String, modifier: Modifier = Modifier) {
    val previewHandler = AsyncImagePreviewHandler {
        ColorImage(Color.LightGray.toArgb())
    }

    CompositionLocalProvider(LocalAsyncImagePreviewHandler provides previewHandler) {
        SubcomposeAsyncImage(
            modifier = modifier
                .clip(RoundedCornerShape(Dimension.MATERIAL_BORDER)),
            model = imageUrl,
            contentScale = ContentScale.FillBounds,
            loading = if (LocalInspectionMode.current) {
                null
            } else {
                { LoadingIndicator() }
            },
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun AnimeAsyncImage_Preview() {
    Column {
        AnimeAsyncImage("https://example.com/image.jpg", modifier = Modifier.fillMaxWidth())
    }
}
