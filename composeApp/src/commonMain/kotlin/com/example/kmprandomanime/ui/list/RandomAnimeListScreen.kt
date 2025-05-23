package com.example.kmprandomanime.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmprandomanime.preview.ComposePreviewData
import com.example.kmprandomanime.ui.core.component.animegriditem.AnimeGridItem
import com.example.kmprandomanime.ui.core.component.floatingaction.KMPRAFloatingActionButton
import com.example.kmprandomanime.ui.core.component.loading.LoadingIndicator
import com.example.kmprandomanime.ui.core.component.topbar.KMPRATopBar
import com.example.kmprandomanime.ui.core.theme.KMPRATheme
import com.example.kmprandomanime.ui.core.theme.icon.Shuffle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun RandomAnimeListScreen(
    viewModel: RandomAnimeListViewModel = koinViewModel(),
    onAnimeClick: (Int) -> Unit,
) {
    val state = viewModel.state.collectAsState().value
    val actions = viewModel.actions
    val navigation = viewModel.navigation

    HandleNavigation(navigation, onAnimeClick)
    RandomAnimeListScreenInternal(state, actions)
}

@Composable
private fun HandleNavigation(
    navigationFlow: Flow<RandomAnimeListNavigation>,
    onAnimeClick: (Int) -> Unit,
) {
    val currentOnAnimeClick by rememberUpdatedState(onAnimeClick)

    LaunchedEffect(Unit) {
        navigationFlow.collectLatest {
            when (it) {
                is RandomAnimeListNavigation.ToAnimeDetails -> currentOnAnimeClick(it.animeId)
                else -> {}
            }
        }
    }
}

@Composable
private fun RandomAnimeTopBar(title: String, onClear: () -> Unit) {
    KMPRATopBar(
        title = title,
        actions = {
            IconButton(onClick = onClear) {
                Icon(Icons.Outlined.Delete, contentDescription = Icons.Outlined.Clear.name)
            }
        },
    )
}

@Composable
private fun RandomAnimeFAB(onGenerate: () -> Unit) {
    KMPRAFloatingActionButton(
        icon = Icons.Shuffle,
        onClick = onGenerate,
    )
}

@Composable
private fun RandomAnimeListScreenInternal(
    state: RandomAnimeListState,
    actions: RandomAnimeListActions,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.error) {
        state.error?.let { snackbarHostState.showSnackbar(it) }
    }

    Scaffold(
        topBar = { RandomAnimeTopBar(state.screenTitle, actions.onClearAnimeList) },
        floatingActionButton = { RandomAnimeFAB(actions.onGenerateRandomAnime) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            LazyVerticalGrid(
                modifier = Modifier,
                columns = GridCells.Adaptive(minSize = 96.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(
                    horizontal = 8.dp,
                    vertical = 8.dp,
                ),
            ) {
                items(state.animeList.size) {
                    AnimeGridItem(
                        animeEntry = state.animeList[it],
                        onAnimeClick = actions.onAnimeClicked,
                    )
                }
            }

            if (state.isLoading) {
                LoadingIndicator()
            }
        }
    }
}

@Preview
@Composable
internal fun RandomAnimeListScreen_Preview(darkTheme: Boolean = false) {
    val animeList = listOf(
        ComposePreviewData.animeEntry(),
        ComposePreviewData.animeEntry(),
        ComposePreviewData.animeEntry(),
        ComposePreviewData.animeEntry(),
        ComposePreviewData.animeEntry(),
    )
    val state = RandomAnimeListState(
        screenTitle = "Random Anime List",
        animeList = animeList,
        isLoading = false,
    )

    KMPRATheme(darkTheme) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            RandomAnimeListScreenInternal(
                state = state,
                actions = RandomAnimeListActions(),
            )
        }
    }
}
