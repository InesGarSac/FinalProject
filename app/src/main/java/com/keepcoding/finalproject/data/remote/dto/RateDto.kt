package com.keepcoding.finalproject.data.remote.dto

import com.squareup.moshi.Json

data class RateDto (
    @Json(name = "rating") val ratingValue: Double
)