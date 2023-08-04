package com.keepcoding.finalproject.domain.usecase

import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.domain.model.MovieModel

class GetDetailUseCase(
    private val movieRepository: MovieRepository
) {

    suspend fun invoke(id: String) : List<MovieModel> = movieRepository.getMovieList()

}
