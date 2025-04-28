package com.example.handscanattendance.data.model

data class UploadPresensiRequest(
    val userId: String,
    val imageBase64: String,
    val mataKuliahId: String,
    val pertemuan: Int
)

data class UploadPresensiResponse(
    val success: Boolean,
    val message: String
)
