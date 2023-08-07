package com.keepcoding.finalproject.domain.model

import com.keepcoding.finalproject.data.remote.dto.IdDto

data class MovieModel(
    val id: IdDto,
    val title: String,
//    val rate: String,
//    val language: String,
    val releaseDate: String,
    val photoUrl: String,
    val overview: String,
    val genres: List<String>?
)
