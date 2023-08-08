package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import com.keepcoding.finalproject.components.CircularIndeterminateProgressBar
import com.keepcoding.finalproject.presentation.list.moviesList.ShowMovieItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteListScreen (
    favoriteListViewModel: FavoriteListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
){
    val state = favoriteListViewModel.movieList.observeAsState()
    val movieList = state.value
    favoriteListViewModel.getFavoritesMoviesList(1)

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(movieList?.size ?: 0) { i ->
            val item = movieList?.get(i)
            item?.let { movie ->
                ShowMovieItem(movie) {
                    onItemClick.invoke(movie.id.id)
                }
            }

        }
    }
}
