package com.keepcoding.finalproject.presentation.list.moviesList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keepcoding.finalproject.components.CircularIndeterminateProgressBar
import org.koin.androidx.compose.koinViewModel



@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
) {

    val state = movieListViewModel.movieList.observeAsState()
    val movieList = state.value
    // Get data from ViewModel

    if (movieList == null) CircularIndeterminateProgressBar(isDisplayed = true)
    
    LazyColumn(
        modifier= Modifier.padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 57.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)

    ) {

        items(movieList?.size ?: 0) { i ->
            val item = movieList?.get(i)
            item?.let { movie ->
                ShowMovieItem(movie, starVisibility = true) {
                    onItemClick.invoke(movie.id.id)
                }
            }

        }
    }
}

@Preview
@Composable
fun MovieListScreenPreview() {
//    MovieListScreen()


}
