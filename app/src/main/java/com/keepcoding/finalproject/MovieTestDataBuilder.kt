package com.keepcoding.finalproject

import com.keepcoding.finalproject.domain.model.MovieModel


class MovieTestDataBuilder {
    val id = "test-id"
    var name = ""
    var title = ""
    var rate = ""
    var language = ""
    var releaseDate = ""
    var photoUrl = ""
    var description = ""
    var numElements: Int = 1

    fun withName(name: String): MovieTestDataBuilder {
        this.name = name
        return this
    }

    fun withPhotoUrl(photoUrl: String): MovieTestDataBuilder {
        this.photoUrl = photoUrl
        return this
    }

    fun withDescription(description: String): MovieTestDataBuilder {
        this.description = description
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
                    id,
                    title = title,
                    rate = rate,
                    language = language,
                    releaseDate = releaseDate,
                    photoUrl = photoUrl
                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = MovieModel(
        id = id,
        title = title, rate = rate,
        language = language,
        releaseDate = releaseDate,
        photoUrl = photoUrl
    )
}

