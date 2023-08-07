package com.keepcoding.finalproject.data.mappers

import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.domain.model.MovieModel

fun MovieDto.toMovieModel() = MovieModel(
    id = id ?: "",
    title= title ?: "",
    releaseDate = releaseDate ?: "" ,
    language= language ?: "",
    rate= rate ?: "",
    photoUrl = photo ?: "",
    overview = description?: "",
    genres = genre
)


fun MovieDto.toMovieLocal() = MovieLocal(
    id = id ?: "",
    title= title ?: "",
    releaseDate = releaseDate ?: "" ,
    language= language ?: "",
    rate= rate ?: "",
    description = description ?: "",
    photo = photo ?: "",
    genres = genre

)

fun MovieLocal.toMovieModel() = MovieModel(
    id = id,
    title= title,
    releaseDate = releaseDate,
    rate = rate,
    language = language,
    overview = description ?: "",
    photoUrl = photo?: "",
    genres = genres
    )