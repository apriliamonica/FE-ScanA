package com.example.handscanattendance.data

import com.google.gson.annotations.SerializedName

data class MataKuliah(
    @SerializedName("id") val id: String,
    @SerializedName("id_mk") val idMk: String,
    @SerializedName("nama") val nama: String,
    @SerializedName("semester") val semester: String,
    @SerializedName("tahun_akademik") val tahunAkademik: String
)
