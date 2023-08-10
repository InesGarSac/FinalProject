package com.keepcoding.finalproject.data

import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.data.local.LocalDataSource
import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.local.model.RateLocal
import com.keepcoding.finalproject.data.local.model.RatingLocal
import com.keepcoding.finalproject.data.mappers.toMovieLocal
import com.keepcoding.finalproject.data.mappers.toMovieModel
import com.keepcoding.finalproject.data.remote.RemoteDataSource
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.data.remote.dto.RateDto
import com.keepcoding.finalproject.data.remote.dto.RatingDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.testutil.getListMovieLocal
import com.keepcoding.finalproject.testutil.getListRemote
import com.keepcoding.finalproject.testutil.movieLocal
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
        coEvery { localDataSource.getMovieLocalList() } returns getListMovieLocal()
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
        coEvery { localDataSource.getFavoriteMovieList(1) } returns getListMovieLocal()

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getFavoriteMovieList(1)

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getMovieById EXPECT local data`() = runTest {
        coEvery { localDataSource.getMovieById("162400") } returns movieLocal

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getMovieById("162400")

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(IdModel(162400)))
    }

    @Test
    fun `WHEN insertFav EXPECT no Exception `() = runTest{
        coEvery { localDataSource.insertMovieList(getListMovieLocal())} returns Unit

        val repo = MovieRepositoryImpl(remoteDataSource, localDataSource)
        repo.updateFavorite(MovieTestDataBuilder().buildSingle())
    }

}