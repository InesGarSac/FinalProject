package com.keepcoding.finalproject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keepcoding.finalproject.components.MainScreenComponent
import com.keepcoding.finalproject.presentation.detail.MovieDetailScreen
import com.keepcoding.finalproject.presentation.list.favoriteList.FavoriteListScreen
import com.keepcoding.finalproject.presentation.list.moviesList.MovieListScreen


fun NavGraphBuilder.addLoginScreen(navController: NavHostController){
    composable(Screen.LoginScreen.route){
        MainScreenComponent{
            navController.navigate(Screen.MovieListScreen.route)
        }
    }
}
fun NavGraphBuilder.addMovieListScreen(navController: NavHostController) {
    composable(Screen.MovieListScreen.route) {
      MovieListScreen{
            movieId ->
            navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
        }
    }
}

fun NavGraphBuilder.addMovieDetailScreen(navController: NavController) {
    composable(
        Screen.MovieDetailScreen.route + "/{movieId}",
        arguments = Screen.MovieDetailScreen.arguments) {
        navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("movieId") ?: ""
        MovieDetailScreen(id = id){
            navController.popBackStack()
        }
    }
}

fun NavGraphBuilder.addFavoriteListScreen(navController: NavHostController){
    composable(
        Screen.FavoriteListScreen.route
    ){
        FavoriteListScreen{
                movieId ->
            navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
        }
    }
}
