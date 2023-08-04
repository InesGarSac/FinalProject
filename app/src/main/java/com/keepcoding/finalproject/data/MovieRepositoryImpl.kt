package com.keepcoding.finalproject.data

import android.util.Log
import com.keepcoding.finalproject.data.mappers.toMovieModel
import com.keepcoding.finalproject.data.remote.RemoteDataSource
import com.keepcoding.finalproject.domain.model.MovieModel

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {

    override suspend fun getMovieList(): List<MovieModel> {

        return remoteDataSource.getMovieList().map {
            it.toMovieModel()
        }

    }
}
