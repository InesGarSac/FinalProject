package com.keepcoding.finalproject.data.remote.dto

import com.squareup.moshi.Json

data class GenreDto (
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
)