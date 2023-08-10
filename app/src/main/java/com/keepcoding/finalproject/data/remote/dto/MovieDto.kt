package com.keepcoding.finalproject.data.remote.dto

import com.squareup.moshi.Json

data class MovieDto(
    @Json(name = "ids") val id: IdDto?,
    @Json(name = "title") val title: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "country") val language: String?,
    @Json(name = "overview") val description: String?,
    @Json(name = "poster") val photo: String?,
    @Json(name = "genres") val genres: List<String>?,
    @Json(name = "ratings") val ratings: RatingDto
)
