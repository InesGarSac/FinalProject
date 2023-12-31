package com.keepcoding.finalproject.data.local

import com.keepcoding.finalproject.data.local.model.MovieLocal

interface LocalDataSource {
    suspend fun insertMovieList(movieList: List<MovieLocal>)
    suspend fun getMovieLocalList() : List<MovieLocal>
    suspend fun getMovieById(id: String): MovieLocal
    suspend fun updateFavorite(movie: MovieLocal)
    suspend fun getFavoriteMovieList(favorite: Int): List<MovieLocal>
}