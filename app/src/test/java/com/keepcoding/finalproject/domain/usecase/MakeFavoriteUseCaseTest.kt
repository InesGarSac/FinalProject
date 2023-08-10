package com.keepcoding.finalproject.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.model.RateModel
import com.keepcoding.finalproject.domain.model.RatingModel
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


class MakeFavoriteUseCaseTest{
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
    fun `WHEN makeFavoriteUseCase init EXPECT List of MovieModel data`() = runTest {
        coEvery { movieRepository.getFavoriteMovieList(1) } returns
                MovieTestDataBuilder().buildList()

        val useCase = MakeFavoriteUseCase(movieRepository)

        val res = useCase.invoke(1)

        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getDetailUseCase id type EXPECT List type`() = runTest {
        coEvery { movieRepository.getFavoriteMovieList(1) } returns
                MovieTestDataBuilder().buildList()

        val useCase = MakeFavoriteUseCase(movieRepository)

        val res = useCase.invoke(1)



        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))

    }

}