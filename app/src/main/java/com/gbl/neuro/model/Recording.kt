package com.gbl.neuro.model

data class Recording(
    val id: Int,
    val name: String,
    val duration: Int,
    val date: String,
    val location: String,
    val description: String,
    val rating: Int,
    val image: String
)

