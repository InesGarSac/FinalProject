package com.keepcoding.finalproject.domain.model

import android.icu.text.CaseMap.Title

data class MovieModel(
    val id: String,
    val title: String,
    val rate: String,
    val language: String,
    val releaseDate: String,
    val photoUrl: String,
    val overview: String,
    val genres: List<String>?
)
