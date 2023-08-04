package com.keepcoding.finalproject.data.remote.dto

import com.squareup.moshi.Json

data class MovieDto(
    @Json(name = "id") val id: String?,
    @Json(name = "original_title") val title: String?,
    @Json(name = "vote_average") val rate: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "original_language") val language: String?,
    @Json(name = "overview") val description: String?,
    @Json(name = "poster_path") val photo: String?
)
