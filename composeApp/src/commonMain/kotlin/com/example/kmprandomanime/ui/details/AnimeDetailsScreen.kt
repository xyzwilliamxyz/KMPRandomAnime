package com.example.kmprandomanime.ui.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.kmprandomanime.domain.model.AnimeEntry
import com.example.kmprandomanime.preview.ComposePreviewData
import com.example.kmprandomanime.ui.core.component.loading.LoadingIndicator
import com.example.kmprandomanime.ui.core.component.topbar.KMPRATopBar
import com.example.kmprandomanime.ui.core.extensions.debugPlaceholder
import com.example.kmprandomanime.ui.core.theme.Dimension
import com.example.kmprandomanime.ui.core.theme.KMPRATheme
import com.example.kmprandomanime.ui.core.theme.icon.Star
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.anime_details_episode_info
import kmprandomanime.composeapp.generated.resources.anime_details_favorites_label
import kmprandomanime.composeapp.generated.resources.anime_details_members_label
import kmprandomanime.composeapp.generated.resources.anime_details_popularity_label
import kmprandomanime.composeapp.generated.resources.anime_details_rank_label
import kmprandomanime.composeapp.generated.resources.anime_details_ranking_value
import kmprandomanime.composeapp.generated.resources.anime_details_score_label
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun AnimeDetailsScreen(
    viewModel: AnimeDetailsViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val state = viewModel.state.collectAsState().value

    AnimeDetailsScreenInternal(state, onBackClick)
}

@Composable
private fun AnimeDetailsTopBar(title: String, onBackClick: () -> Unit) {
    KMPRATopBar(
        onBackClick = onBackClick,
        title = title,
    )
}

@Composable
private fun AnimeDetailsScreenInternal(state: AnimeDetailsState, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            AnimeDetailsTopBar(title = state.screenTitle, onBackClick = onBackClick)
        },
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            state.animeEntry?.let {
                Content(it)
            }

            if (state.isLoading) {
                LoadingIndicator()
            }
        }
    }
}

@Composable
private fun Content(anime: AnimeEntry, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Title(anime.title)
        Spacer(Modifier.height(8.dp))
        Row {
            AnimeImage(anime.imageUrl)
            Rankings(anime)
        }
        Spacer(Modifier.height(16.dp))
        MediaInfo(anime)
        Spacer(Modifier.height(16.dp))
        Summary(anime.summary)
    }
}

@Composable
private fun Title(title: String) {
    Text(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        text = title,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
private fun AnimeImage(imageUrl: String) {
    AsyncImage(
        modifier = Modifier
            .width(160.dp)
            .height(221.dp)
            .clip(RoundedCornerShape(Dimension.MATERIAL_BORDER)),
        model = imageUrl,
        placeholder = debugPlaceholder(),
        error = debugPlaceholder(),
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
    )
}

@Composable
private fun Rankings(anime: AnimeEntry) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
    ) {
        Text(
            text = stringResource(Res.string.anime_details_score_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
        Row {
            Icon(
                modifier = Modifier.size(13.dp),
                imageVector = Icons.Star,
                contentDescription = Icons.Star.name,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = anime.score,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
            )
        }

        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(Res.string.anime_details_rank_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            text = stringResource(Res.string.anime_details_ranking_value, anime.rank),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(Res.string.anime_details_popularity_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            text = stringResource(Res.string.anime_details_ranking_value, anime.popularity),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(Res.string.anime_details_members_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            text = stringResource(Res.string.anime_details_ranking_value, anime.members),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(Res.string.anime_details_favorites_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            text = stringResource(Res.string.anime_details_ranking_value, anime.favorites),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        )
    }
}

@Composable
private fun MediaInfo(anime: AnimeEntry) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = anime.airingPeriod,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = anime.airingStatus,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            text = stringResource(
                Res.string.anime_details_episode_info,
                anime.episodes,
                anime.duration,
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Composable
private fun Summary(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.bodySmall,
        overflow = TextOverflow.Clip,
        textAlign = TextAlign.Justify,
    )
}

@Composable
internal fun AnimeDetailsScreen_Preview() {
    val animeEntry = ComposePreviewData.animeEntry()
    val state = AnimeDetailsState(
        screenTitle = "Anime Details",
        animeEntry = animeEntry,
        isLoading = false,
    )

    KMPRATheme {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            AnimeDetailsScreenInternal(
                state = state,
                onBackClick = {},
            )
        }
    }
}
