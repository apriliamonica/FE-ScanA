package com.example.handscanattendance.data.model

data class Mahasiswa(
    val id: String,
    val nama: String,
    val nim: String,
    val gambarTangan: String, // Path atau URL gambar telapak tangan
    val password: String
)
