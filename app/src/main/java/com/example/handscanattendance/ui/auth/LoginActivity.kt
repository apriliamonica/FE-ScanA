package com.example.handscanattendance.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R
import com.example.handscanattendance.api.ApiService
import com.example.handscanattendance.model.LoginCredentials
import com.example.handscanattendance.model.LoginResponse
import com.example.handscanattendance.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ketika tombol login diklik
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

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
                        // Login berhasil, arahkan ke AdminHomeActivity
                        Toast.makeText(applicationContext, "Login berhasil", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, AdminHomeActivity::class.java))
                        finish()
                    } else {
                        // Login gagal
                        Toast.makeText(applicationContext, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Respons tidak sukses
                    Toast.makeText(applicationContext, "Terjadi kesalahan saat login", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Jika gagal koneksi
                Toast.makeText(applicationContext, "Gagal terkoneksi dengan server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
