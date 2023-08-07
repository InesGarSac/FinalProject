package com.keepcoding.finalproject.data.mappers

import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel

fun MovieDto.toMovieModel() = MovieModel(
    id = IdModel(id.id),
    title = title ?: "",
    releaseDate = releaseDate ?: "" ,
//    language= language ?: "",
//    rate= rate ?: "",
    photoUrl = photo ?: "",
    overview = description?: "",
    genres = genres
)


fun MovieDto.toMovieLocal() = MovieLocal(
    ids = IdLocal(id.id),
    title= title ?: "",
    releaseDate = releaseDate ?: "" ,
//    language= language ?: "",
//    rate= rate ?: "",
    description = description ?: "",
    photo = photo ?: "",
    genres = genres

)

fun MovieLocal.toMovieModel() = MovieModel(
    id = IdModel(ids.id),
    title= title,
    releaseDate = releaseDate,
//    rate = rate,
//    language = language,
    overview = description ?: "",
    photoUrl = photo?: "",
    genres = genres
    )