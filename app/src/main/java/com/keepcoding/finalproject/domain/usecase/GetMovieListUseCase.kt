package com.keepcoding.finalproject.domain.usecase

import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.domain.model.MovieModel

class GetMovieListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke() : List<MovieModel> = movieRepository.getMovieList()

}
