package com.keepcoding.finalproject.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.keepcoding.finalproject.ui.theme.PrimaryColor
import com.keepcoding.finalproject.ui.theme.White

sealed class BottomNavigationScreens(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens("movieList", "Movies", Icons.Filled.List)
    object TV : BottomNavigationScreens("favoriteList", "Favorite", Icons.Filled.Favorite)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationGraph(
    darkMode: MutableState<Boolean>
) {
    val navController = rememberNavController()

    val screens = listOf(
        Screen.MovieListScreen,
        Screen.FavoriteListScreen
    )

    val showBottomBar = navController
        .currentBackStackEntryAsState().value?.destination?.route in screens.map { it.route }

    Scaffold(
        bottomBar = {
            if(showBottomBar){
                BottomNavigation(navController = navController)
            }
        }
    ) {
        NavHost(
            // FragmentContainerView
            navController = navController,
            startDestination = Screen.LoginScreen.route, // Igual que el startDestination
        ) {
            addLoginScreen(navController)
            addMovieListScreen(navController)
            addMovieDetailScreen(navController, darkMode)
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
        backgroundColor = PrimaryColor,
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier.background(MaterialTheme.colors.secondary)
                    .semantics (true) { }
                    .clearAndSetSemantics {
                        contentDescription = item.title
                    },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = White,
                unselectedContentColor = White.copy(0.4f),
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


