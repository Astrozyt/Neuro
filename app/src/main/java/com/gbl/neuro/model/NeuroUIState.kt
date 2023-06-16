package com.gbl.neuro.model

data class NeuroUiState(
    val accelerometerDataPointsLeft: List<Triple<Float, Float, Float>>,
    val accelerometerDataPointsRight: List<Triple<Float, Float, Float>>
)