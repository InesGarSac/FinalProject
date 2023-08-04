package com.keepcoding.finalproject.data.remote.dto

import com.squareup.moshi.Json

data class ResultDto(
    @Json(name = "results") val results: List<MovieDto>
)