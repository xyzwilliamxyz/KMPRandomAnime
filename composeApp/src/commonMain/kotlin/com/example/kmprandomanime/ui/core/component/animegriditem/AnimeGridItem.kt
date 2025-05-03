package com.example.kmprandomanime.ui.core.component.animegriditem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kmprandomanime.domain.model.AnimeEntry
import com.example.kmprandomanime.preview.ComposePreviewData
import com.example.kmprandomanime.ui.core.component.image.AnimeAsyncImage
import com.example.kmprandomanime.ui.core.theme.Dimension
import com.example.kmprandomanime.ui.core.theme.KMPRATheme
import com.example.kmprandomanime.ui.core.theme.icon.Star
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.not_applicable_mean
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun AnimeGridItem(
    animeEntry: AnimeEntry,
    onAnimeClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier
            .fillMaxWidth()
            .height(202.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Column {
            AnimeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(Dimension.MATERIAL_BORDER))
                    .clickable {
                        onAnimeClick(animeEntry.id)
                    },
                imageUrl = animeEntry.imageUrl,
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .padding(top = 4.dp),
                text = animeEntry.title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelSmall,
            )
            Spacer(Modifier.height(4.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
            ) {
                Icon(
                    modifier = Modifier.size(12.dp),
                    imageVector = Icons.Star,
                    contentDescription = Icons.Star.name,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Text(
                    text = animeEntry.score.ifBlank { stringResource(Res.string.not_applicable_mean) },
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelSmall,
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 2.dp),
                    text = animeEntry.mediaType,
                    maxLines = 1,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }
    }
}

@Preview
@Composable
private fun AnimeGridItem_Preview() {
    val entry = ComposePreviewData.animeEntry()

    KMPRATheme {
        Scaffold(
            Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(8.dp),
                columns = GridCells.Adaptive(minSize = 96.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(6) { entry }
            }
        }
    }
}
