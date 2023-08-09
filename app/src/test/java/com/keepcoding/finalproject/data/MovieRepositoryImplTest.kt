package com.keepcoding.finalproject.data

import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.data.local.LocalDataSource
import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.mappers.toMovieLocal
import com.keepcoding.finalproject.data.mappers.toMovieModel
import com.keepcoding.finalproject.data.remote.RemoteDataSource
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class MovieRepositoryImplTest{

    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getMovieList EXPECT local data`() = runTest {
        coEvery { localDataSource.getMovieLocalList() } returns getMovieLocal()
        coEvery { remoteDataSource.getMovieList() } returns listOf<MovieDto>()

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getMovieList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }


    @Test
    fun `WHEN getMovieList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getMovieLocalList() } returns listOf<MovieLocal>()
        coEvery { remoteDataSource.getMovieList() } returns getListRemote()

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getMovieList()

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getFavoriteMovieList EXPECT local data`() = runTest {
        coEvery { localDataSource.getFavoriteMovieList(1) } returns getFavoriteListLocal()

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getFavoriteMovieList(1)

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }




    fun getMovieLocal() = listOf(
        MovieLocal(IdLocal(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
        "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War"),1),

        MovieLocal(IdLocal(430306), "Avengers: Endgame", "English",
            "2019", "After the devastating events of Avengers: Infinity War",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction"),0)

    )

    fun getListRemote() = listOf<MovieDto>(
        MovieDto(
            IdDto(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War")),

        MovieDto(
            IdDto(430306), "Avengers: Endgame", "English",
            "2019", "After the devastating events of Avengers: Infinity War",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction"))
        )

    fun getFavoriteListLocal() = listOf(
        MovieLocal(IdLocal(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War"),1),

        MovieLocal(IdLocal(430306), "Avengers: Endgame", "English",
            "2019", "After the devastating events of Avengers: Infinity War",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction"),0)

        )

}