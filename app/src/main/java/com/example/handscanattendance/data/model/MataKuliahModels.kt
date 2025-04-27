package com.example.handscanattendance.data.model

data class MataKuliahResponse(
    val success: Boolean,
    val message: String
)

data class MataKuliahRequest(
    val id_mk: String,
    val nama_mk: String,
    val semester: String,
    val tahun_akademik: String
)