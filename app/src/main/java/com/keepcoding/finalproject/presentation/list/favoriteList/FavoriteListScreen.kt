package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.keepcoding.finalproject.ui.theme.titleSize
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteListScreen (
    favoriteListViewModel: FavoriteListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
){
    val state = favoriteListViewModel.movieList.observeAsState()
    val movieList = state.value
    favoriteListViewModel.getFavoritesMoviesList(1)

    Row(
        horizontalArrangement = Arrangement.Center) {
        Text(
            modifier= Modifier.padding(
                start = 10.dp,
                top = 5.dp
            ),
            text = "Favorites",
            fontSize = titleSize,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
        )
    }


    LazyColumn(
        modifier= Modifier.padding(
            top = 40.dp,
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
                ShowFavoriteScreen(movie) {
                    onItemClick.invoke(movie.id.id)
                }
            }

        }
    }
}
