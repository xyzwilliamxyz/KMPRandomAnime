package com.example.kmprandomanime.ui.details

import androidx.lifecycle.SavedStateHandle
import com.example.kmprandomanime.ScreenRoute
import com.example.kmprandomanime.core.CoroutineDispatcherProvider
import com.example.kmprandomanime.core.StringProvider
import com.example.kmprandomanime.domain.interactor.GetAnimeByIdInteractor
import com.example.kmprandomanime.preview.ComposePreviewData
import com.example.kmprandomanime.testutils.CoroutineDispatcherProviderTestImpl
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.anime_details_title
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AnimeDetailsViewModelTest {
    private val stringProvider: StringProvider = mockk()
    private val getAnimeByIdInteractor: GetAnimeByIdInteractor = mockk()
    private val dispatcher: CoroutineDispatcherProvider = CoroutineDispatcherProviderTestImpl()
    private val savedStateHandle: SavedStateHandle = mockk()

    private lateinit var viewModel: AnimeDetailsViewModel

    @Before
    fun setup() = runTest {
        coEvery { stringProvider.resolveString(Res.string.anime_details_title) } returns "Anime Details"
        coEvery { getAnimeByIdInteractor(any()) } returns ComposePreviewData.animeEntry()
        coEvery { savedStateHandle.get<Int>(ScreenRoute.Details.ARG_ANIME_ID) } returns 1

        viewModel = AnimeDetailsViewModel(
            stringProvider,
            getAnimeByIdInteractor,
            dispatcher,
            savedStateHandle,
        )
    }

    @Test
    fun `test initial state`() = runTest {
        val expectedState = AnimeDetailsState(
            screenTitle = "Anime Details",
            isLoading = false,
            animeEntry = ComposePreviewData.animeEntry(),
        )

        assertEquals(expectedState, viewModel.state.value)
    }
}
