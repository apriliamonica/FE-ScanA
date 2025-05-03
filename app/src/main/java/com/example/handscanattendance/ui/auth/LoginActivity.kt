package com.example.handscanattendance.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.databinding.ActivityLoginBinding
import com.example.handscanattendance.data.model.LoginCredentials
import com.example.handscanattendance.data.model.LoginResponse
import com.example.handscanattendance.network.RetrofitClient
import com.example.handscanattendance.ui.admin.AdminHomeActivity
//import com.example.handscanattendance.ui.mahasiswa.MahasiswaHomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.tvRegister.setOnClickListener {
            // Menavigasi ke halaman registrasi
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(credentials: LoginCredentials) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.login(credentials)

                // Memeriksa apakah respons sukses
                if (response.isSuccessful) {
                    val loginResponse = response.body()

                    // Pastikan loginResponse tidak null dan valid
                    if (loginResponse != null && loginResponse.success) {
                        val role = loginResponse.data?.role ?: "mahasiswa"
                        val userName = loginResponse.data?.nama ?: "Pengguna"

                        // Tampilkan nama pengguna dan role
                        Toast.makeText(
                            applicationContext,
                            "Welcome $userName, Role: $role",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Navigasi berdasarkan role pengguna
                        if (role == "admin") {
                            startActivity(Intent(this@LoginActivity, AdminHomeActivity::class.java))
//                        } else if (role == "mahasiswa") {
//                            startActivity(Intent(this@LoginActivity, MahasiswaHomeActivity::class.java)) // Halaman mahasiswa
                        } else {
                            Toast.makeText(applicationContext, "Role tidak dikenali", Toast.LENGTH_SHORT).show()
                        }

                        finish() // Menutup login activity setelah berhasil login
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Username atau Password salah",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Terjadi kesalahan saat login",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                // Jika terjadi exception, beri feedback ke pengguna
                Toast.makeText(
                    applicationContext,
                    "Gagal terkoneksi dengan server",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
