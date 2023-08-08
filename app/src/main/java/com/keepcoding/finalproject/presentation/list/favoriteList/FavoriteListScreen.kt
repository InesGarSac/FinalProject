package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteListScreen (
    favoriteListViewModel: FavoriteListViewModel = koinViewModel()
){

    val movieState = favoriteListViewModel.movie.observeAsState()
//    favoriteListViewModel.updateFavorite()
    Text(text = "Favorite List")

}
