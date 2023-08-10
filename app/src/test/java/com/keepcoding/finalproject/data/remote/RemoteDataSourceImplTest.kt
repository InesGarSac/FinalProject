package com.keepcoding.finalproject.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.data.remote.dto.RateDto
import com.keepcoding.finalproject.data.remote.dto.RatingDto
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.getListRemote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RemoteDataSourceImplTest{
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var movieApi: MovieApi

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getHeroList EXPECT local data`() = runTest {
        coEvery { movieApi.getMoviesList() } returns getListRemote()

        val repo = RemoteDataSourceImpl(
            movieApi = movieApi
        )

        val res = repo.getMovieList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }



}