package com.example.handscanattendance.network

import com.example.handscanattendance.model.LoginCredentials
import com.example.handscanattendance.model.LoginResponse
import com.example.handscanattendance.model.RegisterRequest
import com.example.handscanattendance.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(@Body credentials: LoginCredentials): Call<LoginResponse>

    @POST("register")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
}
