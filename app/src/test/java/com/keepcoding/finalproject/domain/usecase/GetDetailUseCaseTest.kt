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

class GetDetailUseCaseTest{
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
    fun `WHEN getDetailUseCase init EXPECT MovieModel data`() = runTest {
        coEvery { movieRepository.getMovieById("162400") } returns movieModel

        val useCase = GetDetailUseCase(movieRepository)

        val res = useCase.invoke("162400").id

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(162400))
    }

    @Test
    fun `WHEN getDetailUseCase id type EXPECT IdModel type`() = runTest {
        coEvery { movieRepository.getMovieById("162400") } returns movieModel

        val useCase = GetDetailUseCase(movieRepository)

        val res = useCase.invoke("162400").id


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(IdModel::class.java))

    }

    private var movieModel = MovieModel(
        IdModel(162400), "Avatar: The Way of Water", "English",
        "2022", "Set more than a decade after the events of the first film",
        "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
        listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingModel(RateModel(2.3))
    )
}