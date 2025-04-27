package com.example.handscanattendance.data.model

data class RegisterRequest(
    val nim: String,
    val nama: String,
    val email: String,
    val no_telp: String,
    val kelas: String,
    val password: String,
    val foto_telapak_kanan: String?,
    val foto_telapak_kiri: String?
)

data class RegisterResponse(
    val success: Boolean,
    val message: String
)
