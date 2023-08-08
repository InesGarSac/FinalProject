package com.keepcoding.finalproject.domain.usecase

import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.mappers.toMovieModel

class GetFavoriteListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke(movie: MovieLocal) = movieRepository.updateFavorite(movie.toMovieModel())

}