package com.r4ng3l.jetpackcomposepokedex.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Type
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeBug
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeDark
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeDragon
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeElectric
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeFairy
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeFighting
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeFire
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeFlying
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeGhost
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeGrass
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeGround
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeIce
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeNormal
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypePoison
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypePsychic
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeRock
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeSteel
import com.r4ng3l.jetpackcomposepokedex.ui.theme.TypeWater

fun getTypeBackgroundBrush(types: List<Type>): Brush {
    val typeColors = types.map { typeEntry ->
        getTypeColor(typeEntry.type.name)
    }

    return if (typeColors.size == 1) {
        // Single type, return SolidColor
        SolidColor(typeColors.first())
    } else {
        // Multiple types, return a gradient Brush
        Brush.horizontalGradient(typeColors)
    }
}

fun getTypeColor(typeName: String): Color {
    return when(typeName) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}