package com.keepcoding.finalproject.domain.model

import com.keepcoding.finalproject.data.remote.dto.IdDto

data class MovieModel(
    val id: IdModel,
    val title: String,
    val country: String,
    val releaseDate: String,
    val photoUrl: String,
    val overview: String,
    val genres: List<String>?,
    var favorite: Int
)
