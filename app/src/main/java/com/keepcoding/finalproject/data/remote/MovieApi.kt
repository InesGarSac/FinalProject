package com.keepcoding.finalproject.data.remote

import com.keepcoding.finalproject.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Headers

//b0d926f8c2e5b66575d770d9fe25f43e
const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMGQ5MjZmOGMyZTViNjY1NzVkNzcwZDlmZTI1ZjQzZSIsInN1YiI6IjY0ZDBkN2MwNmQ0Yzk3MDE0ZjQzMTg0MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.adjc21GeJZzzALXLFv6KkJukyV4EUS7kOMOCSaRsOQE"


//368e649b5c6aa9a36f366c915a7d3cfa
//const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNjhlNjQ5YjVjNmFhOWEzNmYzNjZjOTE1YTdkM2NmYSIsInN1YiI6IjY0YzdmNGY3NDFhYWM0MGZiMmRhZGU0OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.l_L5KvrlcYtr7w9hMC-Bpu-x68W-ayx2aKw_I6UMjYU"


interface MovieApi {


    @GET("trending/?extended=overview,genres&client_id=c45812461936d60195257754b6389e7e95513cd708fbd7bc180530b66a81db41")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getMoviesList(): List<MovieDto>
    // @PUT
    // @DELETE
}
