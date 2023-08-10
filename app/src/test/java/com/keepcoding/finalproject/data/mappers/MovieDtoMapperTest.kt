package com.keepcoding.finalproject.data.mappers

import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.keepcoding.finalproject.data.remote.dto.MovieDto
import com.keepcoding.finalproject.data.remote.dto.RateDto
import com.keepcoding.finalproject.data.remote.dto.RatingDto
import com.keepcoding.finalproject.domain.model.IdModel
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MovieDtoMapperTest {

    @Test
    fun `WHEN to MovieModel with values EXPECT model has value`(){
        val movieDto = MovieDto(
            id = IdDto(546),
            title = "test-title",
            releaseDate = "2022",
            language = "English",
            photo = "https://photo.url",
            genres = listOf("terror"),
            description = "descripcion-test",
            ratings = RatingDto(RateDto(2.3))
        )
        val result = movieDto.toMovieModel()

        assertThat(result.id, `is`(IdModel(546)))
    }

}