package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.usecase.GetFavoriteListUseCase
import com.keepcoding.finalproject.domain.usecase.MakeFavoriteUseCase
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
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
    private lateinit var getFavoriteUseCase: GetFavoriteListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN viewModel init EXPECT null data`() = runTest {
        coEvery { makeFavoriteUseCase.invoke(favorite = 1) } returns MovieTestDataBuilder()
            .withNumElements(3)
            .withId(IdModel(2))
            .withTitle("title")
            .withFavorite(1)
            .buildList()

        val viewModel = FavoriteListViewModel(makeFavoriteUseCase)

        val movieList = viewModel.movieList.value

        MatcherAssert.assertThat(movieList, CoreMatchers.nullValue())

    }

    //TODO: Testear el update
//    @Test
//    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
//        coEvery { getFavoriteUseCase.invoke(name = "film-test") } returns MovieTestDataBuilder()
//            .withId(IdModel(2))
//            .withFavorite(1)
//            .buildSingle()
//
//        val viewModel = FavoriteListViewModel(getFavoriteUseCase)
//
//        val movieList = viewModel.movieList.value
//
//        MatcherAssert.assertThat(movieList, CoreMatchers.nullValue())

//    }

}