package com.keepcoding.finalproject.data.remote.dto

import com.keepcoding.finalproject.domain.model.IdModel
import com.squareup.moshi.Json

data class MovieDto(
    @Json(name = "ids") val id: IdDto?,
    @Json(name = "title") val title: String?,
    @Json(name = "release_date") val releaseDate: String?,
//    @Json(name = "original_language") val language: String?,
    @Json(name = "overview") val description: String?,
    @Json(name = "poster") val photo: String?,
    @Json(name = "genres") val genres: List<String>?
)
