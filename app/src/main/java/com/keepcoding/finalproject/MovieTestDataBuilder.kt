package com.keepcoding.finalproject

import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel


class MovieTestDataBuilder {
    var id = IdModel(546)
    var title = "El diario de Noa"
    var language = "English"
    var releaseYear = "2023"
    var photoUrl = "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg"
    var overview = "Descripción del Diario de Noa"
    var genres = listOf("drama", "comedia", "terror")
    var favorite = 1
    var numElements: Int = 1

    fun withId(id: IdModel): MovieTestDataBuilder {
        this.id = id
        return this
    }
    fun withTitle(title: String): MovieTestDataBuilder {
        this.title = title
        return this
    }

    fun withLanguage(language: String): MovieTestDataBuilder {
        this.language = language
        return this
    }
    fun withReleaseYear(releaseYear: String): MovieTestDataBuilder {
        this.releaseYear = releaseYear
        return this
    }
    fun withPhotoUrl(photoUrl: String): MovieTestDataBuilder {
        this.photoUrl = photoUrl
        return this
    }

    fun withOverview(overview: String): MovieTestDataBuilder {
        this.overview = overview
        return this
    }

    fun withGenres(genres: List<String>): MovieTestDataBuilder {
        this.genres = genres
        return this
    }

    fun withNumElements(numElements: Int): MovieTestDataBuilder {
        this.numElements = numElements
        return this
    }

    fun buildList(): List<MovieModel> {
        val list = mutableListOf<MovieModel>()

        for (i in 0..numElements) {
            list.add(
                MovieModel(
                    id = IdModel(546),
                    title = title,
                    language = language,
                    releaseDate = releaseYear,
                    photoUrl = photoUrl,
                    overview = overview,
                    genres = listOf("drama", "comedia", "terror"),
                    favorite = 1
                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = MovieModel(
        id = IdModel(546),
        title = title,
        language = language,
        releaseDate = releaseYear,
        photoUrl = photoUrl,
        overview = overview,
        genres = listOf("drama", "comedia", "terror"),
        favorite = 1
    )
}

