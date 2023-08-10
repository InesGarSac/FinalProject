package com.keepcoding.finalproject.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.local.model.RateLocal
import com.keepcoding.finalproject.data.local.model.RatingLocal
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.model.RateModel
import com.keepcoding.finalproject.domain.model.RatingModel
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
import com.keepcoding.finalproject.testutil.movieLocal
import com.keepcoding.finalproject.testutil.movieModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetFavoriteListUseCaseTest {

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
        coEvery { movieRepository.updateFavorite(movieModel) } returns Unit

        val useCase = GetFavoriteListUseCase(movieRepository)

        val res = useCase.invoke(movieLocal)

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(Unit::class.java))
    }



}