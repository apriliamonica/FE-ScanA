package com.example.handscanattendance.data.model

data class RegisterRequest(
    val nim: String,
    val nama: String,
    val email: String,
    val phone: String,
    val password: String,
    val palmLeft: String,   // base64 dari telapak kiri
    val palmRight: String   // base64 dari telapak kanan
)


data class RegisterResponse(
    val success: Boolean,
    val message: String
)

