package com.example.handscanattendance.network

import com.example.handscanattendance.data.model.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login") // Endpoint login
    suspend fun login(@Body credentials: Map<String, String>): AuthResponse
}
