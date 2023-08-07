package com.keepcoding.finalproject.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keepcoding.finalproject.presentation.detail.MovieDetailScreen
import com.keepcoding.finalproject.presentation.list.moviesList.MovieListScreen


fun NavGraphBuilder.addMovieListScreen(navController: NavHostController) {
    composable(Screen.MovieListScreen.route) {
        MovieListScreen{ movieId ->
            navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
        }
    }
}

fun NavGraphBuilder.addMovieDetailScreen() {
    composable(
        Screen.MovieDetailScreen.route + "/{movieId}",
        arguments = Screen.MovieDetailScreen.arguments) {
        navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("movieId") ?: ""
        MovieDetailScreen(id = id)
    }
}
