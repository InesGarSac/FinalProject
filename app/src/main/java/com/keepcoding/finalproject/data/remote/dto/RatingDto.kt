package com.keepcoding.finalproject.data.remote.dto

import com.squareup.moshi.Json

data class RatingDto (
    @Json(name = "simkl") val rateVote: RateDto?
)
