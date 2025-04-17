package com.example.handscanattendance.model

data class LoginCredentials(
    val username: String,
    val password: String
)

data class LoginResponse(
    val success: Boolean,
    val message: String
)
