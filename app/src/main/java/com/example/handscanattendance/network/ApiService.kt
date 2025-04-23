package com.example.handscanattendance.network
import com.example.handscanattendance.model.LoginCredentials
import com.example.handscanattendance.model.LoginResponse
import com.example.handscanattendance.model.RegisterRequest
import com.example.handscanattendance.model.RegisterResponse
import com.example.handscanattendance.model.MataKuliahRequest
import com.example.handscanattendance.model.MataKuliahResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.DELETE
import com.example.handscanattendance.model.*
import retrofit2.http.*
interface ApiService {
    @POST("login")
    fun login(@Body credentials: LoginCredentials): Call<LoginResponse>
    @POST("register")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
    @GET("mata-kuliah")
    suspend fun <MataKuliah> getMataKuliah(): List<MataKuliah>
    @POST("mata-kuliah")
    suspend fun tambahMataKuliah(@Body mataKuliah: MataKuliahRequest): MataKuliahResponse
    @DELETE("mata-kuliah/{id}")
    suspend fun hapusMataKuliah(@Path("id") id: String): MataKuliahResponse
}
