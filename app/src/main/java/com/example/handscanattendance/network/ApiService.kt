package com.example.handscanattendance.network

import com.example.handscanattendance.model.LoginCredentials
import com.example.handscanattendance.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body credentials: LoginCredentials): Call<LoginResponse>
}
