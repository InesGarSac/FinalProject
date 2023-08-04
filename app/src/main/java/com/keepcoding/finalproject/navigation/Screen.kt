package com.keepcoding.finalproject.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {

    object MovieListScreen : Screen(
        route = "movieList",
        arguments = emptyList()
    )
}
