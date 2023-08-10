package com.keepcoding.finalproject.data

import com.keepcoding.finalproject.data.local.LocalDataSource
import com.keepcoding.finalproject.data.mappers.toMovieLocal
import com.keepcoding.finalproject.data.mappers.toMovieModel
import com.keepcoding.finalproject.data.remote.RemoteDataSource
import com.keepcoding.finalproject.domain.model.MovieModel

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {

    override suspend fun getMovieList(): List<MovieModel> {
        val localData = localDataSource.getMovieLocalList()
        val remoteData = remoteDataSource.getMovieList()

        if (localData.isNotEmpty()) {
            return localData.map { it.toMovieModel() }
        }
        else{
            localDataSource.insertMovieList(remoteData.map { it.toMovieLocal() })
        }

        return remoteData.map {
            it.toMovieModel()
        }

    }

    override suspend fun getMovieById(id: String): MovieModel = localDataSource.getMovieById(id).toMovieModel()
    override suspend fun updateFavorite(movie: MovieModel) = localDataSource.updateFavorite(movie.toMovieLocal())
    override suspend fun getFavoriteMovieList(favorite: Int): List<MovieModel> {

        return localDataSource.getFavoriteMovieList(favorite).map {
            it.toMovieModel()
        }
    }


}
