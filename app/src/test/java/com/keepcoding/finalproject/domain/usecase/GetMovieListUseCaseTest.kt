package com.keepcoding.finalproject.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.list.moviesList.MovieListViewModel
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class GetMovieListUseCaseTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN useCase init EXPECT MovieModel data`() = runTest {
        coEvery { movieRepository.getMovieList() } returns MovieTestDataBuilder()
            .withNumElements(3)
            .buildList()

        val useCase = GetMovieListUseCase(movieRepository)

        val res = useCase.invoke()

        MatcherAssert.assertThat(res, instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(3))
    }

    @Test
    fun `WHEN useCase first value EXPECT MovieModel type`() = runTest {
        coEvery { movieRepository.getMovieList() } returns MovieTestDataBuilder()
            .withNumElements(3)
            .buildList()

        val useCase = GetMovieListUseCase(movieRepository)

        val res = useCase.invoke()

        MatcherAssert.assertThat(res[0], instanceOf(MovieModel::class.java))

    }
}