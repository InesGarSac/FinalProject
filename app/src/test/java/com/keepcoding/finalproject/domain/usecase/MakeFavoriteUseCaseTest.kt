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

    private var movieModel = MovieModel(
        IdModel(162400), "Avatar: The Way of Water", "English",
        "2022", "Set more than a decade after the events of the first film",
        "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
        listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingModel(RateModel(2.3))
    )
}