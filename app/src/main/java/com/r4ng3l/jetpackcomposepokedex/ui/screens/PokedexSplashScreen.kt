package com.r4ng3l.jetpackcomposepokedex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.r4ng3l.jetpackcomposepokedex.R
import com.r4ng3l.jetpackcomposepokedex.ui.navigation.AppRoutes
import kotlinx.coroutines.delay

@Composable
fun PokedexSplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(timeMillis = 2500)
        navController.popBackStack()
        navController.navigate(AppRoutes.PokedexListScreen.route)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_international_pokemon_logo),
            contentDescription = "Pokemon logo",
            modifier = Modifier.size(250.dp, 250.dp)
        )
    }
}