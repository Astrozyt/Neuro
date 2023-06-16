package com.gbl.neuro.Screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gbl.neuro.model.Measurement
import com.gbl.neuro.model.NeuroViewModel
import kotlin.random.Random

@Composable
fun DetailScreen(navController: NavController, neuroViewModel: NeuroViewModel){

    val newLeftState by neuroViewModel.newLeft.collectAsState()
    Box(contentAlignment = Alignment.Center, modifier = Modifier){
        Text(text = "Thank you for taking part!")


        Log.d("DetailScreen", newLeftState.joinToString { it.toString() })

    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Here is your data:")
            AccelerometerGraph(accelerometerData = newLeftState)
        }

    }

}



@Composable
fun AccelerometerGraph(accelerometerData: List<Triple<Float, Float, Float>>) {
    Canvas(modifier = Modifier
        .background(Color.LightGray)
        .size(width = 300.dp, height = 150.dp)) {
        val graphWidth = size.width
        val graphHeight = size.height
        val dataPoints = accelerometerData.size

        if (dataPoints < 2) return@Canvas

        val xStep = graphWidth / (dataPoints - 1)
        val yStep = graphHeight / 20 // Adjust the scaling factor as needed

        val path = Path()
        path.moveTo(0f, graphHeight - accelerometerData.first().first * yStep)

        for (i in 1 until dataPoints) {
            val x = i * xStep
//            val y = graphHeight - accelerometerData[i].first * yStep
            val y = Random.nextFloat()*graphHeight
            path.lineTo(x, y)
        }

        drawPath(
            path = path,
            color = Color.Blue,
            style = Stroke(width = 2f)
        )
    }

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Save in Database")

    }
}
