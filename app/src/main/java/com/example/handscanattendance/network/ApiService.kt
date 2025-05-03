package com.example.handscanattendance.network

import com.example.handscanattendance.data.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Login & Register (Coroutine)
    @POST("login")
    suspend fun login(@Body credentials: LoginCredentials): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    // Mahasiswa (Coroutine)
    @POST("mahasiswa")
    suspend fun addMahasiswa(@Body mahasiswa: MahasiswaModel): Response<MahasiswaModel>

    @GET("mahasiswa")
    suspend fun getMahasiswa(): List<MahasiswaModel>

    @DELETE("mahasiswa/{id}")
    suspend fun hapusMahasiswa(@Path("id") id: String): Response<MahasiswaModel>

    // Presensi (Coroutine)
    @POST("upload-presensi")
    suspend fun uploadPresensi(@Body request: UploadPresensiRequest): Response<UploadPresensiResponse>

    // Mata Kuliah (Callback biasa → cocok untuk Activity kamu)
    @GET("mata_kuliah")
    fun getMataKuliah(): Call<List<MataKuliah>>

    @POST("mata_kuliah")
    fun tambahMataKuliah(@Body mataKuliah: MataKuliah): Call<MataKuliah>

    @DELETE("mata_kuliah/{id}")
    fun hapusMataKuliah(@Path("id") id: String): Call<MataKuliahResponse>
}
