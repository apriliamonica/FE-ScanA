package com.example.handscanattendance.data

import com.google.gson.annotations.SerializedName

data class Mahasiswa(
    @SerializedName("nim") val nim: String,
    @SerializedName("nama") val nama: String,
    @SerializedName("kelas") val kelas: String
)

