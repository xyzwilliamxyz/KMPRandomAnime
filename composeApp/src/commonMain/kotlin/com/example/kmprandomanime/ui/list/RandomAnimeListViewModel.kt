package com.example.kmprandomanime.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmprandomanime.core.CoroutineDispatcherProvider
import com.example.kmprandomanime.core.StringProvider
import com.example.kmprandomanime.domain.interactor.ClearAllCachedAnimeInteractor
import com.example.kmprandomanime.domain.interactor.GetAllCachedAnimeInteractor
import com.example.kmprandomanime.domain.interactor.GetRandomAnimeInteractor
import com.example.kmprandomanime.domain.interactor.SaveAnimeToCacheInteractor
import com.example.kmprandomanime.domain.model.AnimeEntry
import com.example.kmprandomanime.getPlatform
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.random_anime_list_title
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class RandomAnimeListViewModel(
    private val getRandomAnimeInteractor: GetRandomAnimeInteractor,
    private val getAllCachedAnimeInteractor: GetAllCachedAnimeInteractor,
    private val saveAnimeToCacheInteractor: SaveAnimeToCacheInteractor,
    private val clearAllCachedAnimeInteractor: ClearAllCachedAnimeInteractor,
    private val stringProvider: StringProvider,
    private val dispatcher: CoroutineDispatcherProvider,
) : ViewModel() {
    private val _state = MutableStateFlow(RandomAnimeListState())
    val state = _state.asStateFlow()

    private val _navigation = MutableSharedFlow<RandomAnimeListNavigation>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val navigation = _navigation.asSharedFlow()

    val actions = RandomAnimeListActions(
        onGenerateRandomAnime = ::generateRandomAnime,
        onClearAnimeList = ::clearAnimeList,
        onAnimeClicked = ::onAnimeClicked,
    )

    init {
        initialize()
    }

    private fun initialize() {
        viewModelScope.launch(dispatcher.io()) {
            _state.value = _state.value.copy(
                screenTitle = stringProvider.resolveString(Res.string.random_anime_list_title, getPlatform().name),
                isLoading = true,
            )

            val entries = getAllCachedAnimeInteractor()
            _state.value = _state.value.copy(
                isLoading = false,
                animeList = entries,
            )
        }
    }

    private fun generateRandomAnime() {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch(dispatcher.io()) {
            runCatching {
                val animeEntry = getRandomAnimeInteractor()
                saveAnimeToCacheInteractor(animeEntry)
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = null,
                    animeList = _state.value.animeList.toMutableList().apply { add(animeEntry) },
                )
            }.onFailure { ex ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = ex.message,
                )
            }
        }
    }

    private fun clearAnimeList() {
        viewModelScope.launch(dispatcher.io()) {
            _state.value = _state.value.copy(isLoading = true)

            clearAllCachedAnimeInteractor()

            _state.value = _state.value.copy(
                isLoading = false,
                animeList = emptyList(),
            )
        }
    }

    private fun onAnimeClicked(animeId: Int) {
        viewModelScope.launch(dispatcher.io()) {
            _navigation.emit(RandomAnimeListNavigation.ToAnimeDetails(animeId))
        }
    }
}

internal data class RandomAnimeListActions(
    val onGenerateRandomAnime: () -> Unit = {},
    val onClearAnimeList: () -> Unit = {},
    val onAnimeClicked: (Int) -> Unit = {},
)

internal data class RandomAnimeListState(
    val screenTitle: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val animeList: List<AnimeEntry> = emptyList(),
)

internal sealed class RandomAnimeListNavigation {
    object None : RandomAnimeListNavigation()
    data class ToAnimeDetails(val animeId: Int) : RandomAnimeListNavigation()
}
