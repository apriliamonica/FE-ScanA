package com.example.handscanattendance.data.model

import com.google.gson.annotations.SerializedName

data class MataKuliah(
    val idMk: String,
    val namaMk: String,
    val kelas: String,
    val semester: String,
    val tahunAkademik: String
)

