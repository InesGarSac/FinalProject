package com.keepcoding.finalproject.data.local

import com.keepcoding.finalproject.data.local.model.MovieLocal

class LocalDataSourceImpl(
    private val movieDao: MovieDao
) : LocalDataSource {

    override suspend fun insertMovieList(movieList: List<MovieLocal>) = movieDao.insertAll(movieList)

    override suspend fun getMovieLocalList(): List<MovieLocal> = movieDao.getAllMovies()
}