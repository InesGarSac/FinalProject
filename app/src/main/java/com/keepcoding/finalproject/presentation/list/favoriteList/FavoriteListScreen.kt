package com.keepcoding.finalproject.presentation.list.favoriteList

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Row(
        horizontalArrangement = Arrangement.Center) {
        Text(
            modifier= Modifier.padding(
                start = 10.dp,
                top = 5.dp
            ),
            text = "Favorites",
            fontSize = 22.sp,
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
