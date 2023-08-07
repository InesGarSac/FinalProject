package com.keepcoding.finalproject.presentation.detail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.list.moviesList.POSTER_BASE_URL
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieDetailScreen(
    id: String,
    movieDetailViewModel: MovieDetailViewModel = koinViewModel()
) {

    val movieState = movieDetailViewModel.movie.observeAsState()
    movieDetailViewModel.getMovie(id)

    val resultMovieValue = movieState.value

    resultMovieValue?.let {movie ->
        ShowDetail(movie = movie)
    }

}

@Composable
@Preview
fun MovieDetailScreenPreview() {

}