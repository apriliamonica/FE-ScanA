package com.example.handscanattendance.data.model

data class RegisterRequest(
    val nim: String,
    val nama: String,
    val email: String,
    val no_telp: String,
    val kelas: String,
    val password: String,
    val foto_telapak_kanan: String?,  // base64 string atau null
    val foto_telapak_kiri: String?    // base64 string atau null
)

data class RegisterResponse(
    val success: Boolean,
    val message: String
)
