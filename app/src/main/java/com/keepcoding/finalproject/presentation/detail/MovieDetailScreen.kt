package com.keepcoding.finalproject.presentation.detail

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.components.ShowError
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.list.moviesList.POSTER_BASE_URL
import com.keepcoding.finalproject.ui.theme.PrimaryColor
import com.keepcoding.finalproject.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(
    id: String,
    movieDetailViewModel: MovieDetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {

    val movieState = movieDetailViewModel.movie.observeAsState()
    movieDetailViewModel.getMovie(id)

    val resultMovieValue = movieState.value

    resultMovieValue?.let {movie ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {

                    },
                    backgroundColor = PrimaryColor,
                    contentColor = White,
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                contentDescription = "Atrás Botón Ir al listado de películas"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            ShowDetail(movie = movie)
        }
            
        
    }

}

@Composable
@Preview
fun MovieDetailScreenPreview() {

}