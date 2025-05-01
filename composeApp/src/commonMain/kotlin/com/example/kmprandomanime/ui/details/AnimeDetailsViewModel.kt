package com.example.kmprandomanime.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.anime_details_title
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.kmprandomanime.ScreenRoute
import com.example.kmprandomanime.core.CoroutineDispatcherProvider
import com.example.kmprandomanime.core.StringProvider
import com.example.kmprandomanime.domain.model.AnimeEntry
import com.example.kmprandomanime.domain.interactor.GetAnimeByIdInteractor

internal class AnimeDetailsViewModel(
    private val stringProvider: StringProvider,
    private val getAnimeByIdInteractor: GetAnimeByIdInteractor,
    private val dispatcher: CoroutineDispatcherProvider,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(AnimeDetailsState())
    val state = _state.asStateFlow()

    private val animeId: Int = savedStateHandle[ScreenRoute.Details.ARG_ANIME_ID] ?: -1

    init {
        initialize()
    }

    private fun initialize() {
        viewModelScope.launch(dispatcher.io()) {
            _state.value = _state.value.copy(
                screenTitle = stringProvider.resolveString(Res.string.anime_details_title),
                isLoading = true,
            )

            val animeEntry = getAnimeByIdInteractor(animeId)

            _state.value = _state.value.copy(
                animeEntry = animeEntry,
                isLoading = false,
            )
        }
    }
}

internal data class AnimeDetailsState(
    val screenTitle: String = "",
    val isLoading: Boolean = false,
    val animeEntry: AnimeEntry? = null
)

