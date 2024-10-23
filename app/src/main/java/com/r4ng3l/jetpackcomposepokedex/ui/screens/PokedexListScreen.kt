package com.r4ng3l.jetpackcomposepokedex.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.r4ng3l.jetpackcomposepokedex.ui.navigation.AppRoutes
import com.r4ng3l.jetpackcomposepokedex.ui.theme.PokedexBackground
import com.r4ng3l.jetpackcomposepokedex.ui.theme.PokedexColor
import com.r4ng3l.jetpackcomposepokedex.ui.theme.PokedexEntryBackground
import com.r4ng3l.jetpackcomposepokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexListScreen(navController: NavController) {
    val viewModel: PokedexViewModel = koinViewModel()
    val pokemonList by viewModel.pokemonList.collectAsState()

    // Determine chunk size based on orientation
    val orientation = LocalConfiguration.current.orientation
    val chunkSize = if (orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PokedexColor,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "Pokedex Jetpack Compose",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(PokedexBackground)
                .padding(innerPadding)
        ) {
            LazyColumn {
                items(pokemonList.chunked(size = chunkSize)){ pair ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        pair.forEach { entry ->
                            PokedexEntryItem(
                                name = entry.name.replaceFirstChar { it.uppercase() },
                                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${entry.id}.png"
                                //types = entry.types
                            ) {
                                navController.navigate(route = AppRoutes.PokedexDetailScreen.route + "/${entry.id}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PokedexEntryItem(name: String, imageUrl: String, /*types: List<Type>,*/ onClick: () -> Unit) {
    //val backgroundBrush = getTypeBackgroundBrush(types)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(onClick = onClick)
            .widthIn(min = 200.dp)
            .padding(8.dp)
            //.background(backgroundBrush, RoundedCornerShape(12.dp))
            .background(PokedexEntryBackground, RoundedCornerShape(12.dp))
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = name,
            modifier = Modifier
                .size(128.dp)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color =  Color.White
        )
    }
}
