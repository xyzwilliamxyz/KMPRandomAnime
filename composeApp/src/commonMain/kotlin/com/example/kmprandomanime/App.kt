package com.example.kmprandomanime

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kmprandomanime.ui.core.theme.KMPRATheme
import com.example.kmprandomanime.ui.details.AnimeDetailsScreen
import com.example.kmprandomanime.ui.list.RandomAnimeListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()

    KMPRATheme {
        NavHost(navController, startDestination = ScreenRoute.List.route) {
            composable(ScreenRoute.List.route) {
                RandomAnimeListScreen(
                    onAnimeClick = { animeId ->
                        navController.navigate(ScreenRoute.Details.routeWithArgs(animeId))
                    },
                )
            }
            composable(
                ScreenRoute.Details.route,
                arguments = listOf(navArgument(ScreenRoute.Details.ARG_ANIME_ID) { type = NavType.IntType }),
            ) { backStackEntry ->
                AnimeDetailsScreen(
                    onBackClick = { navController.popBackStack() },
                )
            }
        }
    }
}

sealed class ScreenRoute(val route: String) {
    data object List : ScreenRoute("list")
    data object Details : ScreenRoute("details/{animeId}") {
        const val ARG_ANIME_ID = "animeId"

        fun routeWithArgs(animeId: Int): String = "details/$animeId"
    }
}
