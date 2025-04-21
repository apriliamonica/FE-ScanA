package com.example.handscanattendance.model

data class LoginCredentials(
    val username: String,
    val password: String
)

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: LoginData?  // Tambahkan field 'data' yang berisi LoginData
)

data class LoginData(
    val role: String?,
    val nama: String?
)
