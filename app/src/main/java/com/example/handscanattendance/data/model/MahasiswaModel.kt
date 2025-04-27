package com.example.handscanattendance.data.model

data class MahasiswaModel(
    val nim: String,
    val nama: String,
    val password: String? = null,
    val email: String? = null,
    val phone: String? = null
)

