package com.keepcoding.finalproject.domain.model

import android.provider.Telephony.Mms.Rate
import com.keepcoding.finalproject.MovieTestDataBuilder
import org.hamcrest.CoreMatchers.*
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class MovieModelTest{
     var movieModel = MovieModel(
         id = IdModel(546),
         title = "El diario de Noa",
         language = "English",
         releaseDate = "2023",
         photoUrl = "https://wsrv.nl/?url=https://simkl.in/posters/14/140677817e83851404_w.jpg",
         overview = "Descripción del Diario de Noa",
         genres = listOf("drama", "comedia", "terror"),
         favorite = 1,
         RatingModel(RateModel(2.3))
     )

     @Test
     fun `WHEN create model EXPECT not null value`(){
         assertThat(movieModel, instanceOf(MovieModel::class.java))
         assertThat(movieModel, notNullValue())
     }

    @Test
    fun `WHEN movieModel id is 546 EXPECT id = 546`() {
        val movie = MovieTestDataBuilder().buildSingle()
        assertThat(movie.id, CoreMatchers.`is`(IdModel(546)))
    }

    @Test
    fun `WHEN movieModel title is 'El diario de Noa' EXPECT title = 'El diario de Noa'`() {
        val movie = MovieTestDataBuilder()
            .withTitle("El diario de Noa")
            .buildSingle()
        assertThat(movie.title, CoreMatchers.`is`("El diario de Noa"))
    }

    @Test
    fun `WHEN movieModel language is 'English' EXPECT language = 'English'`() {
        val movie = MovieTestDataBuilder()
            .withLanguage("English")
            .buildSingle()
        assertThat(movie.language, CoreMatchers.`is`("English"))
    }

    @Test
    fun `WHEN movieModel releaseYear is '2023' EXPECT releaseYear = '2023'`() {
        val movie = MovieTestDataBuilder()
            .withReleaseYear("2023")
            .buildSingle()
        assertThat(movie.releaseDate, CoreMatchers.`is`("2023"))
    }

    @Test
    fun `WHEN creates movieModel EXPECT photoUrl contains schema`() {
        assertThat(movieModel.photoUrl, movieModel.photoUrl.startsWith("https"))
    }

    @Test
    fun `WHEN movieModel overview is '2023' EXPECT overview = '2023'`() {
        val movie = MovieTestDataBuilder()
            .withOverview("Descripción del Diario de Noa")
            .buildSingle()
        assertThat(movie.overview, CoreMatchers.`is`("Descripción del Diario de Noa"))
    }

    @Test
    fun `WHEN movieModel genres is 'drama, comedia, terror' EXPECT genres = 'drama, comedia, terror'`() {

        val movie = MovieTestDataBuilder()
            .withGenres(listOf("drama", "comedia", "terror"))
            .buildSingle()
        assertThat(movie.genres?.size, `is`(3))
    }

    @Test
    fun `WHEN movieModel genres first value is 'drama' EXPECT genres first() = 'drama'`() {

        val movie = MovieTestDataBuilder()
            .withGenres(listOf("drama", "comedia", "terror"))
            .buildSingle()
        assertThat(movie.genres?.first(), `is`("drama"))
    }

    @Test
    fun `WHEN movieModel genres second value is 'drama' EXPECT genres second value = 'comedia'`() {

        val movie = MovieTestDataBuilder()
            .withGenres(listOf("drama", "comedia", "terror"))
            .buildSingle()
        assertThat(movie.genres?.indexOf("comedia"), `is`(1))
    }

    @Test
    fun `WHEN movieModel genres last value is 'drama' EXPECT genres last value = 'comedia'`() {

        val movie = MovieTestDataBuilder()
            .withGenres(listOf("drama", "comedia", "terror"))
            .buildSingle()
        assertThat(movie.genres?.last(), `is`("terror"))
    }
 }