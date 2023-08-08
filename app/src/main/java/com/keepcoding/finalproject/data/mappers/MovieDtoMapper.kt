package com.keepcoding.finalproject.data.mappers

import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
fun MovieDto.toMovieModel() = MovieModel(
    id = IdModel(id?.id!!),
    title = title ?: "",
    releaseDate = releaseDate ?: "" ,
//    rank = rank!!,
    country = language ?: "",
    photoUrl = photo ?: "",
    overview = description?: "",
    genres = genres,
    favorite = 0
)


fun MovieDto.toMovieLocal() = MovieLocal(
    ids = IdLocal(id?.id!!),
    title= title ?: "",
    releaseDate = releaseDate ?: "" ,
//    rank = rank!!,
    language= language ?: "",
    description = description ?: "",
    photo = photo ?: "",
    genres = genres,
    favorite = 0

)

fun MovieLocal.toMovieModel() = MovieModel(
    id = IdModel(ids.id),
    title= title,
    releaseDate = releaseDate,
//    rank = rank,
    country = language,
    overview = description ?: "",
    photoUrl = photo?: "",
    genres = genres,
    favorite = favorite!!
)

fun MovieModel.toMovieLocal() = MovieLocal(
    ids = IdLocal(id.id),
    title= title,
    releaseDate = releaseDate,
//    rank = rank,
    language = country,
    description = overview,
    photo = photoUrl,
    genres = genres,
    favorite = favorite
)