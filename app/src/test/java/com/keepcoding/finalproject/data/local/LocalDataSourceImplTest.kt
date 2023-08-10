package com.keepcoding.finalproject.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.getListMovieLocal
import com.keepcoding.finalproject.testutil.movieLocal
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
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

        val repo = LocalDataSourceImpl(movieDao)

        val res = repo.getMovieLocalList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getMovieById EXPECT local data`() = runTest {


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

        val repo = LocalDataSourceImpl(movieDao)
        val res = repo.getFavoriteMovieList(2)


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN insertAll EXPECT no Exception `() = runTest{
        coEvery { movieDao.insertAll(getListMovieLocal())} returns Unit

        val repo = LocalDataSourceImpl(movieDao)
        repo.updateFavorite(movieLocal)
    }




}