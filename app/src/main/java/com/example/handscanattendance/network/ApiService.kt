package com.example.handscanattendance.network

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login") // Endpoint login
    suspend fun login(@Body credentials: Map<String, String>): AuthResponse
}
