package com.keepcoding.finalproject.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.model.RateModel
import com.keepcoding.finalproject.domain.model.RatingModel
import com.keepcoding.finalproject.testutil.DefaultDispatcherRule
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

}