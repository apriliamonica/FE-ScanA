package com.example.handscanattendance.repository

import com.example.handscanattendance.network.ApiService
import com.example.handscanattendance.data.model.AuthResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService
) {
    // Fungsi untuk melakukan login (contoh)
    suspend fun login(username: String, password: String): AuthResponse {
        return apiService.login(username, password) // Memanggil API
    }
}
