package com.example.kmprandomanime.data.local.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.kmprandomanime.data.local.mapper.toAnimeEntity
import com.example.kmprandomanime.preview.ComposePreviewData
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AnimeDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var animeDao: AnimeDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java,
        ).allowMainThreadQueries().build()

        animeDao = database.animeDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun `test insert and get anime`() = runTest {
        val anime = ComposePreviewData.animeEntry().toAnimeEntity()

        animeDao.insertAnime(anime)

        val result = animeDao.getAnimeById(1)

        assertEquals(anime.id, result?.id)
    }

    @Test
    fun `test delete all anime`() = runTest {
        val anime1 = ComposePreviewData.animeEntry().toAnimeEntity()
        val anime2 = ComposePreviewData.animeEntry().copy(id = 2).toAnimeEntity()

        animeDao.insertAnime(anime1)
        animeDao.insertAnime(anime2)

        assertEquals(2, animeDao.getAllAnime().size)

        animeDao.deleteAllAnime()

        assertEquals(0, animeDao.getAllAnime().size)
    }

    @Test
    fun `test get all anime`() = runTest {
        val anime1 = ComposePreviewData.animeEntry().toAnimeEntity()
        val anime2 = ComposePreviewData.animeEntry().copy(id = 2).toAnimeEntity()

        animeDao.insertAnime(anime1)
        animeDao.insertAnime(anime2)

        val result = animeDao.getAllAnime()

        assertEquals(2, result.size)
        assertEquals(anime1.id, result[0].id)
        assertEquals(anime2.id, result[1].id)
    }
}
