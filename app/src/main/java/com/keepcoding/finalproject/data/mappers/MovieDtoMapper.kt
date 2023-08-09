package com.keepcoding.finalproject.data.mappers

import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.local.model.RateLocal
import com.keepcoding.finalproject.data.local.model.RatingLocal
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.model.RateModel
import com.keepcoding.finalproject.domain.model.RatingModel

fun MovieDto.toMovieModel() = MovieModel(
    id = IdModel(id?.id!!),
    title = title ?: "",
    releaseDate = releaseDate ?: "" ,
    language = language ?: "",
    photoUrl = photo ?: "",
    overview = description?: "",
    genres = genres,
    favorite = 0,
    rating = RatingModel(RateModel(ratings.rateVote?.ratingValue!!))
)


fun MovieDto.toMovieLocal() = MovieLocal(
    ids = IdLocal(id?.id!!),
    title= title ?: "",
    releaseDate = releaseDate ?: "" ,
    language= language ?: "",
    description = description ?: "",
    photo = photo ?: "",
    genres = genres,
    favorite = 0,
    rating = RatingLocal(RateLocal(ratings.rateVote?.ratingValue!!))

)

fun MovieLocal.toMovieModel() = MovieModel(
    id = IdModel(ids.id),
    title= title,
    releaseDate = releaseDate,
    language = language,
    overview = description ?: "",
    photoUrl = photo?: "",
    genres = genres,
    favorite = favorite!!,
    rating = RatingModel(RateModel(rating.rateVote.rateValue))
)


fun MovieModel.toMovieLocal() = MovieLocal(
    ids = IdLocal(id.id),
    title= title,
    releaseDate = releaseDate,
    language = language,
    description = overview,
    photo = photoUrl,
    genres = genres,
    favorite = favorite,
    rating = RatingLocal(RateLocal(rateValue = rating.rateVote.rate))
)