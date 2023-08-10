package com.keepcoding.finalproject.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(
    id: String,
    movieDetailViewModel: MovieDetailViewModel = koinViewModel(),
    darkMode: MutableState<Boolean>,
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
                        "Detail"
                    },
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = White,
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                contentDescription = "Film list"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }

                    },
                    actions = {
                        IconButton(
                            modifier = Modifier.alpha(1f),
                            onClick = {
                                darkMode.value = !darkMode.value
                            }
                        ) {
                            Icon(
                                painter = if(darkMode.value){
                                    painterResource(id = R.drawable.ligth_mode)
                                }else{
                                    painterResource(id = R.drawable.night_mode)
                                },
                                contentDescription = ""
                            )
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