package com.r4ng3l.jetpackcomposepokedex.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(color = 0xFFD0BCFF)
val PurpleGrey80 = Color(color = 0xFFCCC2DC)
val Pink80 = Color(color = 0xFFEFB8C8)

val Purple40 = Color(color = 0xFF6650a4)
val PurpleGrey40 = Color(color = 0xFF625b71)
val Pink40 = Color(color = 0xFF7D5260)

val LightBlue = Color(color = 0xFFBAC7FF)
val lightGrey = Color(color = 0xFFAAAAAA)

val PokedexColor = Color(color = 0xFFC7343E)
val PokedexBackground = Color(color = 0xFF272629)

val PokedexEntryBackground = Brush.linearGradient(
    colors = listOf(
        Color(color = 0xFFBDC3C7), // Light Grey
        Color(color = 0xFF2C3E50), // Muted Blue-Grey
        Color(color = 0xFFA7A9AB)  // Soft Silver
    ),
    start = Offset(0f, 0f),
    end = Offset(1000f, 1000f)
)

val HPColor = Color(color = 0xFFD43947)
val AtkColor = Color(color = 0xFFFCA826)
val DefColor = Color(color = 0xFF0091EB)
val SpAtkColor = Color(red = 0.671f, green = 0f, blue = 1f, alpha = 0.57f)
val SpDefColor = Color(red = 1f, green = 0f, blue = 0.8f, alpha = 0.7f)
val SpdColor = Color(red = 0f, green = 1f, blue = 0.063f, alpha = 0.55f)

val TypeNormal = Color(color = 0xFFA8A77A)
val TypeFire = Color(color = 0xFFEE8130)
val TypeWater = Color(color = 0xFF6390F0)
val TypeElectric = Color(color = 0xFFF7D02C)
val TypeGrass = Color(color = 0xFF7AC74C)
val TypeIce = Color(color = 0xFF96D9D6)
val TypeFighting = Color(color = 0xFFC22E28)
val TypePoison = Color(color = 0xFFA33EA1)
val TypeGround = Color(color = 0xFFE2BF65)
val TypeFlying = Color(color = 0xFFA98FF3)
val TypePsychic = Color(color = 0xFFF95587)
val TypeBug = Color(color = 0xFFA6B91A)
val TypeRock = Color(color = 0xFFB6A136)
val TypeGhost = Color(color = 0xFF735797)
val TypeDragon = Color(color = 0xFF6F35FC)
val TypeDark = Color(color = 0xFF705746)
val TypeSteel = Color(color = 0xFFB7B7CE)
val TypeFairy = Color(color = 0xFFD685AD)