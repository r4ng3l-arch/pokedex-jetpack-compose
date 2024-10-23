package com.r4ng3l.jetpackcomposepokedex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.r4ng3l.jetpackcomposepokedex.ui.screens.PokedexDetailScreen
import com.r4ng3l.jetpackcomposepokedex.ui.screens.PokedexListScreen
import com.r4ng3l.jetpackcomposepokedex.ui.screens.PokedexSplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.PokedexSplashScreen.route) {
        composable(route = AppRoutes.PokedexSplashScreen.route){
            PokedexSplashScreen(navController = navController)
        }
        composable(route = AppRoutes.PokedexListScreen.route) {
            PokedexListScreen(navController = navController)
        }
        composable(
            route = AppRoutes.PokedexDetailScreen.route + "/{pokemon_id}",
            arguments = listOf(
                navArgument(name = "pokemon_id"){
                    type = NavType.IntType
                }
            )
        ) {
            PokedexDetailScreen(navController = navController, it.arguments?.getInt("pokemon_id"))
         }
    }
}