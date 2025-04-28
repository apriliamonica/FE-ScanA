package com.example.handscanattendance.network

import com.example.handscanattendance.data.model.LoginCredentials
import com.example.handscanattendance.data.model.LoginResponse
import com.example.handscanattendance.data.model.MahasiswaModel
import com.example.handscanattendance.data.model.MataKuliahResponse
import com.example.handscanattendance.data.model.MataKuliahRequest
import com.example.handscanattendance.data.model.RegisterRequest
import com.example.handscanattendance.data.model.RegisterResponse
import com.example.handscanattendance.data.model.UploadPresensiRequest
import com.example.handscanattendance.data.model.UploadPresensiResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Login
    @POST("login")
    suspend fun login(@Body credentials: LoginCredentials): Response<LoginResponse>

    // Register
    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    // Menambahkan Mahasiswa
    @POST("mahasiswa")
    suspend fun addMahasiswa(@Body mahasiswa: MahasiswaModel): Response<MahasiswaModel>

    // Mendapatkan Daftar Mahasiswa
    @GET("mahasiswa")
    suspend fun getMahasiswa(): List<MahasiswaModel>

    // Menghapus Mahasiswa berdasarkan ID
    @DELETE("mahasiswa/{id}")
    suspend fun hapusMahasiswa(@Path("id") id: String): Response<MahasiswaModel>

    // Upload Foto Presensi
    @POST("upload-presensi")
    suspend fun uploadPresensi(@Body request: UploadPresensiRequest): Response<UploadPresensiResponse>


    // Mendapatkan Daftar Mata Kuliah
    @GET("mata-kuliah")
    suspend fun getMataKuliah(): List<MataKuliahResponse>

    // Menambahkan Mata Kuliah
    @POST("mata-kuliah")
    suspend fun tambahMataKuliah(@Body mataKuliah: MataKuliahRequest): Response<MataKuliahResponse>

    // Menghapus Mata Kuliah
    @DELETE("mata-kuliah/{id}")
    suspend fun hapusMataKuliah(@Path("id") id: String): Response<MataKuliahResponse>
}
