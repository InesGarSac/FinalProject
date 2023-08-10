package com.keepcoding.finalproject.presentation.list.favoriteList

import android.provider.Telephony.Mms.Rate
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.model.RateModel
import com.keepcoding.finalproject.domain.model.RatingModel
import com.keepcoding.finalproject.domain.usecase.GetFavoriteListUseCase
import com.keepcoding.finalproject.domain.usecase.MakeFavoriteUseCase
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class FavoriteListViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var makeFavoriteUseCase: MakeFavoriteUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN viewModel init EXPECT list`() = runTest {
        coEvery { makeFavoriteUseCase.invoke(favorite = 1) } returns MovieTestDataBuilder()
                        .buildList()

        val viewModel = FavoriteListViewModel(makeFavoriteUseCase)
        viewModel.getFavoritesMoviesList(1)

        val movieList = viewModel.movieList.getOrAwaitValue()

        assertThat(movieList, instanceOf(List::class.java))

    }

    @Test
    fun `WHEN viewModel init EXPECT error`() = runTest {
        coEvery { makeFavoriteUseCase.invoke(favorite = 0) } returns MovieTestDataBuilder()
            .buildList()

        val viewModel = FavoriteListViewModel(makeFavoriteUseCase)
        viewModel.getFavoritesMoviesList(1)

        val movieList = viewModel.movieList.getOrAwaitValue()

        assertThat(movieList.size, `is`(0))

    }


    @Test
    fun `WHEN viewModel init EXPECT null data`() = runTest {
        coEvery { makeFavoriteUseCase.invoke(movieModelTest) } returns Unit

        val viewModel = FavoriteListViewModel(makeFavoriteUseCase)
        viewModel.updateFavorite(movieModelTest)

        val movieList = viewModel.movieList.value

        MatcherAssert.assertThat(movieList, CoreMatchers.nullValue())
    }

    private var movieModelTest = MovieModel(
        IdModel(256), "prueba", "english",
        "2023", "https//:photo.com", "description", listOf
            ("drama", "comedia"), 1, RatingModel(RateModel(2.3))
    )


    }