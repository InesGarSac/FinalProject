package com.keepcoding.finalproject.data.local

import com.keepcoding.finalproject.data.local.model.MovieLocal

class LocalDataSourceImpl(
    private val movieDao: MovieDao
) : LocalDataSource {

    override suspend fun insertMovieList(movieList: List<MovieLocal>) = movieDao.insertAll(movieList)

    override suspend fun getMovieLocalList(): List<MovieLocal> = movieDao.getAllMovies()
    override suspend fun getMovieById(id: String): MovieLocal = movieDao.getMovieById(id)
    override suspend fun updateFavorite(movie: MovieLocal) = movieDao.updateFavorite(movie)
    override suspend fun getFavoriteMovieList(): List<MovieLocal> {
        TODO("Not yet implemented")
    }

}