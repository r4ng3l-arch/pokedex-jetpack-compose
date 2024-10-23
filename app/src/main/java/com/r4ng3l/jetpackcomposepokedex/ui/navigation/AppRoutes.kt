package com.r4ng3l.jetpackcomposepokedex.ui.navigation

sealed class AppRoutes(val route: String) {
    data object PokedexSplashScreen: AppRoutes(route = "pokedex_splash_screen")
    data object PokedexListScreen: AppRoutes(route = "pokedex_list_screen")
    data object PokedexDetailScreen: AppRoutes(route = "pokedex_detail_screen")
}