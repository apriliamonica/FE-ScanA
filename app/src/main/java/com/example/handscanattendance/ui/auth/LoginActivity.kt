package com.example.handscanattendance.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.databinding.ActivityLoginBinding
import com.example.handscanattendance.model.LoginCredentials
import com.example.handscanattendance.model.LoginResponse
import com.example.handscanattendance.network.ApiService
import com.example.handscanattendance.network.RetrofitClient
import com.example.handscanattendance.ui.admin.AdminHomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cek jika sudah login sebelumnya
        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            // Skip langsung ke home jika sudah login
            startActivity(Intent(this, AdminHomeActivity::class.java))
            finish()
            return
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val credentials = LoginCredentials(username, password)
                loginUser(credentials)
            } else {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(credentials: LoginCredentials) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val call = apiService.login(credentials)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.success) {
                        Toast.makeText(applicationContext, "Login berhasil", Toast.LENGTH_SHORT).show()

                        // Simpan status login
                        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putBoolean("isLoggedIn", true)
                            apply()
                        }

                        // Pindah ke AdminHomeActivity
                        startActivity(Intent(this@LoginActivity, AdminHomeActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(applicationContext, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Terjadi kesalahan saat login", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Gagal terkoneksi dengan server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
