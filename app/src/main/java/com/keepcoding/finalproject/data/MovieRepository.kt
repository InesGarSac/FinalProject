package com.keepcoding.finalproject.data

import com.keepcoding.finalproject.domain.model.MovieModel


interface MovieRepository {
    suspend fun getMovieList(): List<MovieModel>
//    suspend fun getMovieById(id: String): MovieModel

}
