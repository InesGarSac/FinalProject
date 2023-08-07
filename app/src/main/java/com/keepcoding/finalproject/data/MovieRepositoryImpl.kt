package com.keepcoding.finalproject.data

import android.util.Log
import com.keepcoding.finalproject.data.local.LocalDataSource
import com.keepcoding.finalproject.data.mappers.toMovieModel
import com.keepcoding.finalproject.data.remote.RemoteDataSource
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.list.moviesList.POSTER_BASE_URL

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {

    override suspend fun getMovieList(): List<MovieModel> {
//        val localData = localDataSource.getMovieLocalList()
        val remoteData = remoteDataSource.getMovieList()

//        if (localData.isNotEmpty()) {
//            return localData.map { it.toMovieModel() }
//        }
//        else{
//            localDataSource.insertMovieList(remoteData.map { it.toMovieLocal() })
//        }

        remoteData.map {
            Log.d("FOTOOO", POSTER_BASE_URL +"/posters/" + it.photo.toString()+ "_w.jpg")
        }


        return remoteData.map {
            it.toMovieModel()

        }

    }

//    override suspend fun getMovieById(id: String): MovieModel = localDataSource.getMovieById(id).toMovieModel()
}
