package com.keepcoding.finalproject.presentation.list.moviesList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.domain.usecase.GetMovieListUseCase
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MovieListViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getMovieListUseCase: GetMovieListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
        coEvery { getMovieListUseCase.invoke() } returns MovieTestDataBuilder()
            .withNumElements(3)
            .buildList()

        val viewModel = MovieListViewModel(getMovieListUseCase)

        val res = viewModel.movieList.getOrAwaitValue()

        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(3))

    }
}