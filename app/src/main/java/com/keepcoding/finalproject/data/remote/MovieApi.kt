package com.keepcoding.finalproject.data.remote

import com.keepcoding.finalproject.data.remote.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Headers


const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNjhlNjQ5YjVjNmFhOWEzNmYzNjZjOTE1YTdkM2NmYSIsInN1YiI6IjY0YzdmNGY3NDFhYWM0MGZiMmRhZGU0OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.l_L5KvrlcYtr7w9hMC-Bpu-x68W-ayx2aKw_I6UMjYU"
interface MovieApi {


    @GET("discover/movie/?api_key=368e649b5c6aa9a36f366c915a7d3cfa")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getMoviesList(): ResultDto
    // @PUT
    // @DELETE
}
