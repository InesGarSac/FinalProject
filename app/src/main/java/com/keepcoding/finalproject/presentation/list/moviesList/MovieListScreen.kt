package com.keepcoding.finalproject.presentation.list.moviesList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keepcoding.finalproject.components.CircularIndeterminateProgressBar
import com.keepcoding.finalproject.components.ShowError
import com.keepcoding.finalproject.utils.convertBooleanToInt
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
) {

    val state = movieListViewModel.movieList.observeAsState()
    val errorState = movieListViewModel.errorMessage.observeAsState()
    val movieList = state.value

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    if (movieList == null || errorState.value?.isNotEmpty() == false) CircularIndeterminateProgressBar(isDisplayed = true)

    LazyVerticalGrid(
        modifier= Modifier.padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 57.dp
        ),
        columns = GridCells.Adaptive(minSize = 88.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)

    ) {

        items(movieList?.size ?: 0) { i ->
            val item = movieList?.get(i)
            item?.let { movie ->
                ShowMovieItem(movie, stateOfStar = convertBooleanToInt(movie.favorite)) {
                    onItemClick.invoke(movie.id.id)
                }
            }

        }
    }

}



@Preview
@Composable
fun MovieListScreenPreview() {
}
