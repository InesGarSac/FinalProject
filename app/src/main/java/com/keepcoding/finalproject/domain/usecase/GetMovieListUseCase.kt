package com.keepcoding.finalproject.domain.usecase

import com.keepcoding.finalproject.data.MovieRepository

class GetMovieListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke() = movieRepository.getMovieList()

}
