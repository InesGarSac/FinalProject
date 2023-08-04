package com.keepcoding.finalproject.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keepcoding.finalproject.presentation.list.moviesList.MovieListScreen


fun NavGraphBuilder.addHeroListScreen(navController: NavHostController) {
    composable(Screen.MovieListScreen.route) {
        MovieListScreen{ movieId ->
            navController.navigate("${Screen.MovieListScreen.route}/$movieId")
        }
    }
}
