package com.r4ng3l.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.r4ng3l.jetpackcomposepokedex.ui.navigation.AppNavigation
import com.r4ng3l.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposePokedexTheme {
                AppNavigation()
            }
        }
    }
}

