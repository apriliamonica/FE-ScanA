package com.example.handscanattendance.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.159.39:8000/api/auth/login") // IP backend temanmu + port
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
