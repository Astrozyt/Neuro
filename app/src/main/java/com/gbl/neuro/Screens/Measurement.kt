package com.gbl.neuro.Screens

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import androidx.core.os.bundleOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gbl.neuro.R
import com.gbl.neuro.model.NeuroViewModel


@Composable
fun Measurement(navController: NavController, neuroViewModel: NeuroViewModel) {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(SENSOR_SERVICE) as SensorManager }
    val accelerometerDataPointsLeft = remember { mutableStateListOf<Triple<Float, Float, Float>>() }
    val accelerometerDataPointsRight = remember { mutableStateListOf<Triple<Float, Float, Float>>() }
    val accelerometerSensor = remember {sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)}
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

    myMediaPlayer.setOnCompletionListener { mp ->
        mp.reset()
        mp.release()
    }



    val accelerometerEventListener = remember {
        object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                // Handle accelerometer data here
                if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
                    val x = event.values[0]
                    val y = event.values[1]
                    val z = event.values[2]
                    // Process accelerometer data as needed
                    if(side== "left") {
                        accelerometerDataPointsLeft.add(Triple(x, y, z))
                    } else {
                        accelerometerDataPointsRight.add(Triple(x, y, z))
                    }

                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Handle accuracy changes if needed
            }
        }
    }

    fun registerAccelerometerListener() {
        sensorManager.registerListener(
            accelerometerEventListener,
            accelerometerSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    fun unregisterAccelerometerListener() {
        sensorManager.unregisterListener(accelerometerEventListener)
    }

    fun startTimer() {
        isMeasurementActive = true
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                isMeasurementActive = false
                myMediaPlayer.start()

                if(side=="left"){
                    side = "right"
                    neuroViewModel.addLeftReading( accelerometerDataPointsLeft)
                } else {
                    navController.navigate(Screen.DetailScreen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
                unregisterAccelerometerListener()
            }
        }.start()

        registerAccelerometerListener()
    }




    Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Text(text = "New Measurement $timer", modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.padding(8.dp))
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

