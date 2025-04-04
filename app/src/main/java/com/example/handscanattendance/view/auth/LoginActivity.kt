package com.example.handscanattendance.view.auth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.Mahasiswa
import com.example.handscanattendance.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Menghubungkan komponen UI dengan variabel
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvRegister: TextView = findViewById(R.id.tvRegister)

        // Set listener untuk tombol login
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Panggil fungsi login dari ViewModel
            authViewModel.login(username, password)
        }

        // Observe hasil login
        authViewModel.authResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                // Menampilkan pesan jika login berhasil
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                // Pindahkan ke activity berikutnya (misal Dashboard)
                // Intent(this, DashboardActivity::class.java).apply {
                //     startActivity(this)
                //     finish()
                // }

            } else {
                // Menampilkan pesan jika login gagal
                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show()
            }
        })

        // Set listener untuk registrasi (belum ada implementasi, bisa ditambahkan)
        tvRegister.setOnClickListener {
            // Arahkan ke activity registrasi
            // Intent(this, RegisterActivity::class.java).apply {
            //     startActivity(this)
            // }
        }
    }
}
