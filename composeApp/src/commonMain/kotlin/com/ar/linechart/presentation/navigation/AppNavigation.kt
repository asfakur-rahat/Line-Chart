package com.ar.linechart.presentation.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ar.linechart.presentation.chart.ChartScreen
import com.ar.linechart.presentation.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen

@Serializable
data object ChartScreen


@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(startDestination = HomeScreen, navController = navController){
        composable<HomeScreen>{
            HomeScreen {
                navController.navigate(ChartScreen)
            }
        }
        composable<ChartScreen> {
            ChartScreen {
                navController.navigateUp()
            }
        }
    }

}