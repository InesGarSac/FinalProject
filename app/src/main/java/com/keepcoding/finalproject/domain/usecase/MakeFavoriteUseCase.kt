package com.keepcoding.finalproject.domain.usecase

import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.data.mappers.toMovieLocal
import com.keepcoding.finalproject.domain.model.MovieModel

class MakeFavoriteUseCase(
    private val movieRepository: MovieRepository
    ) {
    suspend fun invoke(movie: MovieModel) = movieRepository.updateFavorite(movie)
    suspend fun invoke(favorite: Int) = movieRepository.getFavoriteMovieList(favorite)


}