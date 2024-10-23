package com.r4ng3l.jetpackcomposepokedex.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Pokemon
import com.r4ng3l.jetpackcomposepokedex.ui.theme.AtkColor
import com.r4ng3l.jetpackcomposepokedex.ui.theme.DefColor
import com.r4ng3l.jetpackcomposepokedex.ui.theme.HPColor
import com.r4ng3l.jetpackcomposepokedex.ui.theme.SpAtkColor
import com.r4ng3l.jetpackcomposepokedex.ui.theme.SpDefColor
import com.r4ng3l.jetpackcomposepokedex.ui.theme.SpdColor

@Composable
fun CustomStat(pokemon: Pokemon, stat: String) {
    val maxStat = 200 // Example max stat for all stats
    val statLabel = when(stat) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "S-ATK"
        "special-defense" -> "S-DEF"
        "speed" -> "SPD"
        else -> "fuck"
    }
    val barColor = when(stat) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.Black
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Text label for the stat
        Text(
            text = statLabel,
            style = MaterialTheme.typography.labelLarge,
            color = Color.LightGray,
            modifier = Modifier.width(55.dp) // Fixed width for labels
        )

        // Progress bar representing the stat
        val currentStat = pokemon.stats.firstOrNull { it.stat.name == stat }?.baseStat ?: 0
        val progressFraction = currentStat.toFloat() / maxStat.coerceAtLeast(minimumValue = 1) // Prevent division by 0

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
        ) {
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progressFraction)
                    .background(barColor, shape = RoundedCornerShape(12.dp))
                    .padding(horizontal = 8.dp) // Add padding inside the colored box
            ) {
                // Text for current stat / max Stat
                Text(
                    text = "$currentStat",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }
    }
}