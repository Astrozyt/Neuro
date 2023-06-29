package com.gbl.neuro.model

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbl.neuro.network.ExperimentApi
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class NeuroViewModel(): ViewModel() {

    private val _newLeft = MutableStateFlow<List<Triple<Float, Float, Float>>>(emptyList())
    val newLeft = _newLeft.asStateFlow()

    private val _webRequestState = MutableStateFlow<String>("")
    val webRequestState = _webRequestState.asStateFlow()

    fun addLeftReading(reading: List<Triple<Float, Float, Float>>) {
        _newLeft.update { it + reading }
    }

    fun clearWebState() {
        _webRequestState.update { "" }
    }

    fun getExperimentAnswer(data: String) {
        viewModelScope.launch {
            Log.d("Going to send", data)
            val myResult = ExperimentApi.retrofitService.getAnswer(data, "Schorsch", "Device1", "Sensor123", OffsetDateTime.now().format(
                DateTimeFormatter.ISO_OFFSET_DATE_TIME))
            Log.d("Received", myResult)
            _webRequestState.update { myResult }
        }
    }
}