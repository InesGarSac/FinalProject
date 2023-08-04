package com.keepcoding.finalproject.data.remote

import android.util.Log
import com.keepcoding.finalproject.data.remote.dto.MovieDto

class RemoteDataSourceImpl(
    private val movieApi: MovieApi
) : RemoteDataSource {
    override suspend fun getMovieList(): List<MovieDto> {
        Log.d("Remote", "${movieApi.getMoviesList().results}")
       return movieApi.getMoviesList().results
    }


}