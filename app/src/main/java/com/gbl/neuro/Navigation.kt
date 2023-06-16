@file:OptIn(ExperimentalMaterial3Api::class)

package com.gbl.neuro


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gbl.neuro.Screens.DetailScreen
import com.gbl.neuro.Screens.HomeScreen
import com.gbl.neuro.Screens.Measurement
import com.gbl.neuro.Screens.Screen
import com.gbl.neuro.model.NeuroViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
val neuroViewModel: NeuroViewModel = viewModel()
    NavHost(navController=navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route){
            DetailScreen(navController = navController, neuroViewModel = neuroViewModel)
        }
        composable(route = Screen.MeasurementScreen.route){
            Measurement(navController = navController, neuroViewModel = neuroViewModel)
        }

    }
}

