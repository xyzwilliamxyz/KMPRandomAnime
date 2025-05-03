package com.example.kmprandomanime.ui.list

import com.example.kmprandomanime.core.CoroutineDispatcherProvider
import com.example.kmprandomanime.core.StringProvider
import com.example.kmprandomanime.domain.interactor.ClearAllCachedAnimeInteractor
import com.example.kmprandomanime.domain.interactor.GetAllCachedAnimeInteractor
import com.example.kmprandomanime.domain.interactor.GetRandomAnimeInteractor
import com.example.kmprandomanime.domain.interactor.SaveAnimeToCacheInteractor
import com.example.kmprandomanime.domain.model.AnimeEntry
import com.example.kmprandomanime.preview.ComposePreviewData
import com.example.kmprandomanime.testutils.CoroutineDispatcherProviderTestImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kmprandomanime.composeapp.generated.resources.Res
import kmprandomanime.composeapp.generated.resources.random_anime_list_title
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RandomAnimeListViewModelTest {
    private val getRandomAnimeInteractor: GetRandomAnimeInteractor = mockk()
    private val getAllCachedAnimeInteractor: GetAllCachedAnimeInteractor = mockk()
    private val saveAnimeToCacheInteractor: SaveAnimeToCacheInteractor = mockk()
    private val clearAllCachedAnimeInteractor: ClearAllCachedAnimeInteractor = mockk()
    private val stringProvider: StringProvider = mockk()
    private val dispatcher: CoroutineDispatcherProvider = CoroutineDispatcherProviderTestImpl()

    private lateinit var viewModel: RandomAnimeListViewModel

    @Before
    fun setup() = runTest {
        coEvery { stringProvider.resolveString(Res.string.random_anime_list_title, any<String>()) } returns "Random Anime List"
        coEvery { getAllCachedAnimeInteractor() } returns listOf(ComposePreviewData.animeEntry())

        viewModel = RandomAnimeListViewModel(
            getRandomAnimeInteractor,
            getAllCachedAnimeInteractor,
            saveAnimeToCacheInteractor,
            clearAllCachedAnimeInteractor,
            stringProvider,
            dispatcher,
        )
    }

    @Test
    fun `test initial state`() = runTest {
        val expectedState = RandomAnimeListState(
            screenTitle = "Random Anime List",
            isLoading = false,
            animeList = listOf(ComposePreviewData.animeEntry()),
        )

        assertEquals(expectedState, viewModel.state.value)
    }

    @Test
    fun `test generate random anime`() = runTest {
        val randomAnime = ComposePreviewData.animeEntry()
        coEvery { getRandomAnimeInteractor() } returns randomAnime
        coEvery { saveAnimeToCacheInteractor(randomAnime) } returns Unit

        viewModel.actions.onGenerateRandomAnime()

        assertEquals(randomAnime, viewModel.state.value.animeList.firstOrNull())
        coVerify(exactly = 1) { saveAnimeToCacheInteractor(randomAnime) }
    }

    @Test
    fun `test clear anime list`() = runTest {
        val randomAnime = ComposePreviewData.animeEntry()
        coEvery { getAllCachedAnimeInteractor() } returns listOf(randomAnime)
        coEvery { clearAllCachedAnimeInteractor() } returns Unit

        assertEquals(1, viewModel.state.value.animeList.size)

        viewModel.actions.onClearAnimeList()

        assertEquals(emptyList<AnimeEntry>(), viewModel.state.value.animeList)
    }

    @Test
    fun `test on anime clicked`() = runTest {
        val randomAnime = ComposePreviewData.animeEntry()
        val expectedNavigation = RandomAnimeListNavigation.ToAnimeDetails(randomAnime.id)
        val deferredNavigation = async {
            viewModel.navigation.first()
        }

        viewModel.actions.onAnimeClicked(randomAnime.id)

        assertEquals(expectedNavigation, deferredNavigation.await())
    }
}
