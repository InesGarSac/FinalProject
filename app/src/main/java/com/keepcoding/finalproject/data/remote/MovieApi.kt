package com.keepcoding.finalproject.data.remote

import com.keepcoding.finalproject.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieApi {
    @GET("trending/?extended=overview,genres&client_id=c45812461936d60195257754b6389e7e95513cd708fbd7bc180530b66a81db41")
    @Headers("Authorization: Bearer ")
    suspend fun getMoviesList(): List<MovieDto>
}
