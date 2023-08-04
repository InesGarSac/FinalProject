package com.keepcoding.finalproject.presentation.list.moviesList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel



@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {

    val state = movieListViewModel.movieList.observeAsState()
    // Get data from ViewModel

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val movieList = state.value

        items(movieList?.size ?: 0) { i ->
            val item = movieList?.get(i)
            item?.let { movie ->
                ShowMovieItem(movie) {
                    onItemClick.invoke(movie.id)
                }
            }

        }
    }
}

@Preview
@Composable
fun MovieListScreenPreview() {
    MovieListScreen{

    }
}
