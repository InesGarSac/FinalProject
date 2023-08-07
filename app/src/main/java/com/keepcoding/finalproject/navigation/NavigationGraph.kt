package com.keepcoding.finalproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost( // FragmentContainerView
        navController = navController,
        startDestination = Screen.MovieListScreen.route, // Igual que el startDestination
    ) {
        addMovieListScreen(navController)
        addMovieDetailScreen()
    }
}
