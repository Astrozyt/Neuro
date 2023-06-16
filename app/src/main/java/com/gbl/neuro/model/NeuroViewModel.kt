package com.gbl.neuro.model

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NeuroViewModel(): ViewModel() {

    private val _newLeft = MutableStateFlow<List<Triple<Float, Float, Float>>>(emptyList())
    val newLeft = _newLeft.asStateFlow()

    fun addLeftReading(reading: List<Triple<Float, Float, Float>>) {
        _newLeft.update { it + reading }
    }
}