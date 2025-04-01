package com.example.handsccanattendance.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.handsccanattendance.data.UserRepository

class AuthViewModel : ViewModel() {
    private val userRepository = UserRepository()

    fun login(email: String, password: String): LiveData<Boolean> {
        val result = MutableLiveData<Boolean>()
        result.value = userRepository.login(email, password)
        return result
    }
}