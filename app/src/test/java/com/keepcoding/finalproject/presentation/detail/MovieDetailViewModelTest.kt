package com.keepcoding.finalproject.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.usecase.GetDetailUseCase
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieDetailViewModelTest{
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var detailUseCase: GetDetailUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN detail viewModel getData EXPECT returns data`() = runTest {
        coEvery { detailUseCase.invoke("546") } returns
                MovieTestDataBuilder().buildSingle()

        val viewModel = MovieDetailViewModel(detailUseCase)

        viewModel.getMovie("546")

        val res = viewModel.movie.getOrAwaitValue()

        assertThat(res.id, CoreMatchers.`is`(IdModel(546)))
    }
}