package com.r4ng3l.jetpackcomposepokedex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Pokemon
import com.r4ng3l.jetpackcomposepokedex.ui.theme.PokedexBackground
import com.r4ng3l.jetpackcomposepokedex.utils.CustomStat
import com.r4ng3l.jetpackcomposepokedex.utils.getTypeBackgroundBrush
import com.r4ng3l.jetpackcomposepokedex.utils.getTypeColor
import com.r4ng3l.jetpackcomposepokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexDetailScreen(navController: NavController, id: Int?) {
    val viewModel: PokedexViewModel = koinViewModel()
    val pokemonDetails by viewModel.pokemonDetails.collectAsState()

    LaunchedEffect(id) {
        if (id != null) {
            viewModel.fetchPokemonDetails(id = id)
        }
    }

    pokemonDetails?.let { pokemon ->
        val backgroundBrush = getTypeBackgroundBrush(types = pokemon.types)

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent, // I want to use it here too
                        titleContentColor = Color.White
                    ),
                    modifier = Modifier.background(backgroundBrush),
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                        ) {
                            Text(
                                text = pokemon.name.replaceFirstChar { it.uppercase() },
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "#${pokemon.id.toString().padStart(length = 3, padChar = '0')}", // Add leading zeros
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Arrow back",
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(PokedexBackground)
                    .verticalScroll(rememberScrollState())
            ) {
                ImageAndName(pokemon = pokemon, backgroundBrush = backgroundBrush)
                Types(pokemon = pokemon)
                WeightAndHeight(pokemon = pokemon)
                Stats(pokemon = pokemon)
                Spacer(modifier = Modifier.padding(bottom = 16.dp))
            }
        }
    }
}

@Composable
fun ImageAndName(pokemon: Pokemon, backgroundBrush: Brush) {
    // Image
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = backgroundBrush,
                shape = RoundedCornerShape(
                    topStart = 0.dp, topEnd = 0.dp, bottomStart = 32.dp, bottomEnd = 32.dp
                )
            )
            .padding(12.dp)
    ) {
        AsyncImage(
            model = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/${pokemon.id.toString().padStart(length = 3, padChar = '0')}.png",
            contentDescription = pokemon.name,
            modifier = Modifier.size(242.dp)
        )
    }

    // Name
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color =  Color.White
        )
    }
}

@Composable
fun Types(pokemon: Pokemon) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        pokemon.types.forEach { typeEntry ->
            val typeColor = getTypeColor(typeEntry.type.name)
            Text(
                textAlign = TextAlign.Center,
                text = typeEntry.type.name.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .widthIn(min = 150.dp)
                    .background(typeColor, shape = RoundedCornerShape(24.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun WeightAndHeight(pokemon: Pokemon) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        // Weight
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "${pokemon.weight / 10} KG",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color =  Color.White
            )
            Text(
                text = "Weight",
                style = MaterialTheme.typography.labelLarge,
                color = Color.LightGray
            )
        }

        // Height
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "${pokemon.height / 10} M",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color =  Color.White
            )
            Text(
                text = "Height",
                style = MaterialTheme.typography.labelLarge,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun Stats(pokemon: Pokemon) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Base Stats",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color =  Color.White
        )
    }
    CustomStat(pokemon = pokemon, stat = "hp")
    CustomStat(pokemon = pokemon, stat = "attack")
    CustomStat(pokemon = pokemon, stat = "defense")
    CustomStat(pokemon = pokemon, stat = "special-attack")
    CustomStat(pokemon = pokemon, stat = "special-defense")
    CustomStat(pokemon = pokemon, stat = "speed")
}