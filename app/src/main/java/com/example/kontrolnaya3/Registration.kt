package com.example.kontrolnaya3
import java.io.Serializable

data class Registration(
    val countChild: Int,
    val countAdult: Int,
    val flight: String,
    val firstName: String,
    val lastName: String,
    val price: Double
) : Serializable