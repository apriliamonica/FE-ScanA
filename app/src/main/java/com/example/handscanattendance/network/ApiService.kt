package com.example.handscanattendance.network

import com.example.handscanattendance.data.Mahasiswa
import com.example.handscanattendance.data.model.LoginCredentials
import com.example.handscanattendance.data.model.LoginResponse
import com.example.handscanattendance.data.model.MataKuliahRequest
import com.example.handscanattendance.data.model.MataKuliahResponse
import com.example.handscanattendance.data.model.RegisterRequest
import com.example.handscanattendance.data.model.RegisterResponse
import retrofit2.http.*
import retrofit2.http.GET

interface ApiService {
    // Login
    @POST("login")
    suspend fun login(@Body credentials: LoginCredentials): LoginResponse

    // Register
    @POST("register")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    // Mendapatkan Daftar Mahasiswa
    @GET("mahasiswa")
    suspend fun getMahasiswa(): List<Mahasiswa>

    // Menghapus Mahasiswa berdasarkan ID
    @DELETE("mahasiswa/{id}")
    suspend fun hapusMahasiswa(@Path("id") id: String): Mahasiswa

    // Mendapatkan Daftar Mata Kuliah
    @GET("mata-kuliah")
    suspend fun getMataKuliah(): List<MataKuliahResponse>

    // Menambahkan Mata Kuliah
    @POST("mata-kuliah")
    suspend fun tambahMataKuliah(@Body mataKuliah: MataKuliahRequest): MataKuliahResponse

    // Menghapus Mata Kuliah
    @DELETE("mata-kuliah/{id}")
    suspend fun hapusMataKuliah(@Path("id") id: String): MataKuliahResponse
}
