package com.keepcoding.finalproject.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.local.model.RateLocal
import com.keepcoding.finalproject.data.local.model.RatingLocal
import com.keepcoding.finalproject.data.remote.MovieApi
import com.keepcoding.finalproject.data.remote.RemoteDataSourceImpl
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import net.bytebuddy.asm.Advice.Local
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class LocalDataSourceImplTest {

    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var movieDao: MovieDao

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }


    @Test
    fun `WHEN getMovieLocalList EXPECT local data`() = runTest {
        coEvery { movieDao.getAllMovies() } returns getListMovieLocal()

        val repo = LocalDataSourceImpl(
            movieDao = movieDao
        )

        val res = repo.getMovieLocalList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getMovieById EXPECT local data`() = runTest {
        var movieLocal = MovieLocal(
            IdLocal(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingLocal(RateLocal(2.3))
        )

        coEvery { movieDao.getMovieById("2") } returns movieLocal

        val repo = LocalDataSourceImpl(
            movieDao = movieDao
        )
        val res = repo.getMovieById("2")

        MatcherAssert.assertThat(res.ids, CoreMatchers.`is`(IdLocal(162400)))
    }

    @Test
    fun `WHEN getFavoriteMovieList EXPECT list of local data`() = runTest {
        coEvery { movieDao.getAllFavoriteMovies(2) } returns getListMovieLocal()

        val repo = LocalDataSourceImpl(
            movieDao = movieDao
        )

        val res = repo.getFavoriteMovieList(2)


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }



    fun getListMovieLocal() = listOf(
        MovieLocal(
            IdLocal(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingLocal(RateLocal(2.3))
        ),

        MovieLocal(
            IdLocal(430306), "Avengers: Endgame", "English",
            "2019", "After the devastating events of Avengers: Infinity War",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction"),1, RatingLocal(RateLocal(2.3))
        )
    )
}