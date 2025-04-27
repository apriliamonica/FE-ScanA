package com.example.handscanattendance.data

import com.google.gson.annotations.SerializedName

data class Mahasiswa(
    @SerializedName("id") val no: Int,
    @SerializedName("nim") val nim: String,
    @SerializedName("nama") val nama: String,
    @SerializedName("kelas") val kelas: String
)

