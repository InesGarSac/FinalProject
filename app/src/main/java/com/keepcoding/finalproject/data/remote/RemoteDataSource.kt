package com.keepcoding.finalproject.data.remote

import com.keepcoding.finalproject.data.remote.dto.MovieDto

interface RemoteDataSource {
    suspend fun getMovieList(): List<MovieDto>
}