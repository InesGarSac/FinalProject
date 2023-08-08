package com.keepcoding.finalproject

import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.domain.model.IdModel
import com.keepcoding.finalproject.domain.model.MovieModel


class MovieTestDataBuilder {
    var id = "movie-id"
    var name = ""
    var title = ""
    var rate = ""
    var language = ""
    var releaseDate = ""
    var photoUrl = ""
    var description = ""
    var genres = listOf<String>()
    var numElements: Int = 1

    fun withId(id: String): MovieTestDataBuilder {
        this.id = id
        return this
    }
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

//    fun buildList(): List<MovieModel> {
//        val list = mutableListOf<MovieModel>()
//
//        for (i in 0..numElements) {
//            list.add(
//                MovieModel(
//                    id = IdModel(23),
//                    title = title,
////                    rate = rate,
////                    language = language,
//                    releaseDate = releaseDate,
//                    photoUrl = photoUrl,
//                    overview = description,
//                    genres = listOf()
//                )
//            )
//        }
//
//        return list.toList()
//    }

//    fun buildSingle() = MovieModel(
//        id = IdModel(35),
//        title = title,
////        rate = rate,
////        language = language,
//        releaseDate = releaseDate,
//        photoUrl = photoUrl,
//        overview = description,
//        genres = listOf()
//    )
}

