@file:OptIn(ExperimentalMaterial3Api::class)

package com.gbl.neuro.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gbl.neuro.model.NeuroViewModel

@Composable
fun HomeScreen(navController: NavController, neuroViewModel: NeuroViewModel){
    var text by remember {
        mutableStateOf("")
    }

    neuroViewModel.clearWebState();

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.
        fillMaxWidth().
        padding(horizontal = 50.dp).fillMaxHeight()
    ){
        Text(text = "Neuro Status", modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(8.dp).align(Alignment.CenterHorizontally))
        Button(onClick = {neuroViewModel.getExperimentAnswer("TEST") }, modifier= Modifier.align(Alignment.CenterHorizontally)){
            Text(text="Test connection")
        }
        Button(onClick = {navController.navigate(Screen.MeasurementScreen.route)}, modifier= Modifier.align(Alignment.CenterHorizontally)){
            Text(text="New Measurement")
        }
    }
}

