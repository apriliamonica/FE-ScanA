package com.example.handscanattendance.data.model

data class LoginCredentials(
    val email: String,
    val password: String
)

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: LoginData? = null // Optional dengan default null
)

data class LoginData(
    val role: String? = null,
    val nama: String? = null
)
