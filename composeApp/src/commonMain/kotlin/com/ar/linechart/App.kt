package com.ar.linechart

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.ar.linechart.presentation.navigation.AppNavigation

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        AppNavigation(navController)
    }
}