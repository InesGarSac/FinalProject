package com.keepcoding.finalproject.domain.model

data class MovieModel(
    val id: IdModel,
    val title: String,
    val language: String,
    val releaseDate: String,
    val photoUrl: String,
    val overview: String,
    val genres: List<String>?,
    var favorite: Int,
    var rating: RatingModel
)
