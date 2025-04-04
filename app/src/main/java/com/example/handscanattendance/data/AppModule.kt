package com.example.handscanattendance.di

import com.example.handscanattendance.network.ApiService
import com.example.handscanattendance.repository.AuthRepository
import com.example.handscanattendance.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val gson: Gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) // Base URL untuk API
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java) // Membuat instansi ApiService
    }

    @Provides
    @Singleton
    fun provideAuthRepository(apiService: ApiService): AuthRepository {
        return AuthRepository(apiService) // Mengembalikan instance AuthRepository
    }
}
