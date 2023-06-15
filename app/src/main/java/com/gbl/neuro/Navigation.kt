@file:OptIn(ExperimentalMaterial3Api::class)

package com.gbl.neuro

//import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gbl.neuro.Screens.DetailScreen
import com.gbl.neuro.Screens.HomeScreen
import com.gbl.neuro.Screens.Measurement
import com.gbl.neuro.Screens.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route, arguments = listOf(
            navArgument("name"){
            type = NavType.StringType
            defaultValue = "No Name"
                nullable = true
        })){entry ->
            DetailScreen(name=entry.arguments?.getString("name") ?: "NoNameGiven")
        }
        composable(route = Screen.MeasurementScreen.route){
            Measurement(navController = navController)
        }

    }
}

