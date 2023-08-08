package com.keepcoding.finalproject.navigation

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.keepcoding.finalproject.R

sealed class BottomNavigationScreens(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens("movieList", "Home", Icons.Filled.Home)
    object TV : BottomNavigationScreens("FavoriteList", "Favorite", Icons.Filled.Favorite)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {BottomNavigation(navController = navController)
        }
    ) {
        NavHost(
            // FragmentContainerView
            navController = navController,
            startDestination = Screen.MovieListScreen.route, // Igual que el startDestination
        ) {
            addMovieListScreen(navController)
            addMovieDetailScreen()
            addFavoriteListScreen(navController)
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.TV
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
