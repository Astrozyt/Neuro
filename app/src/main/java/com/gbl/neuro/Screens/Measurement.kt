package com.gbl.neuro.Screens

import android.content.Context.SENSOR_SERVICE
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gbl.neuro.R


@Composable
fun Measurement(navController: NavController) {
    val context = LocalContext.current
    val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager
    val initialSeconds = 15
    var side by remember {
        mutableStateOf("left")
    }
    var isMeasurementActive by remember {
        mutableStateOf(false)
    }

    var timer by remember {
        mutableStateOf(initialSeconds)
    }

    val myMediaPlayer = MediaPlayer.create(context, R.raw.bell)

    fun startTimer() {
        isMeasurementActive = true
        object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                isMeasurementActive = false
                myMediaPlayer.start()
                side = "right"
            }
        }.start()
    }

    Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Text(text = "New Measurement $timer", modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.padding(8.dp))
//        Image(painter = , contentDescription = )
        Text(buildAnnotatedString {
            append("Take the phone into your ")
            withStyle(style = SpanStyle(color = Color.Red)) {
                append(side)
            }
            append(" hand and press the button to start the measurement.")
        })

Spacer(modifier = Modifier.padding(8.dp))
        if(isMeasurementActive) {
            Text(text = "Measurement is active")
        } else {
            Button(onClick = { startTimer() }) {
                Text(text = "Start!!")
            }
        }

    }
}

