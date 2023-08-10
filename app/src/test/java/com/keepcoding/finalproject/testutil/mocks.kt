package com.keepcoding.finalproject.testutil

import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.local.model.RateLocal
import com.keepcoding.finalproject.data.local.model.RatingLocal
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.data.remote.dto.RateDto
import com.keepcoding.finalproject.data.remote.dto.RatingDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.model.RateModel
import com.keepcoding.finalproject.domain.model.RatingModel


    var movieLocal = MovieLocal(
        IdLocal(162400), "Avatar: The Way of Water", "English",
        "2022", "Set more than a decade after the events of the first film",
        "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
        listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingLocal(RateLocal(2.3))
    )


     var movieModel = MovieModel(
        IdModel(162400), "Avatar: The Way of Water", "English",
        "2022", "Set more than a decade after the events of the first film",
        "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
        listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingModel(RateModel(2.3))
    )

    fun getListMovieLocal() = listOf(
        MovieLocal(
            IdLocal(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War"),1, RatingLocal(RateLocal(2.3))
        ),

        MovieLocal(
            IdLocal(430306), "Avengers: Endgame", "English",
            "2019", "After the devastating events of Avengers: Infinity War",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction"),1, RatingLocal(RateLocal(2.3))
        )
    )

    fun getListRemote() = listOf<MovieDto>(
        MovieDto(
            IdDto(162400), "Avatar: The Way of Water", "English",
            "2022", "Set more than a decade after the events of the first film",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction", "War"), RatingDto(RateDto(2.3))
        ),

        MovieDto(
            IdDto(430306), "Avengers: Endgame", "English",
            "2019", "After the devastating events of Avengers: Infinity War",
            "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
            listOf("Action", "Adventure", "Science Fiction"), RatingDto(RateDto(2.3))
        )
    )
