package com.keepcoding.finalproject.data.remote

import com.keepcoding.finalproject.data.remote.dto.MovieDto

class RemoteDataSourceImpl(
    private val movieApi: MovieApi
) : RemoteDataSource {
    override suspend fun getMovieList(): List<MovieDto> = movieApi.getMoviesList()



}