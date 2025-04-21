package com.example.handscanattendance.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R
import com.example.handscanattendance.model.RegisterRequest
import com.example.handscanattendance.model.RegisterResponse
import com.example.handscanattendance.network.ApiService
import com.example.handscanattendance.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNIM: EditText
    private lateinit var etNama: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var spinnerKelas: Spinner
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvLoginRedirect: TextView
    private lateinit var btnUploadRightPalm: Button
    private lateinit var btnUploadLeftPalm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi komponen
        etNIM = findViewById(R.id.etNIM)
        etNama = findViewById(R.id.etNama)
        etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)
        spinnerKelas = findViewById(R.id.spinnerKelas)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)
        tvLoginRedirect = findViewById(R.id.tvLoginRedirect)
        btnUploadRightPalm = findViewById(R.id.btnUploadRightPalm)
        btnUploadLeftPalm = findViewById(R.id.btnUploadLeftPalm)

        // Dummy data untuk spinner kelas
        val kelasList = listOf("A", "B", "C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, kelasList)
        spinnerKelas.adapter = adapter

        // Event tombol daftar
        btnRegister.setOnClickListener {
            val nim = etNIM.text.toString()
            val nama = etNama.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()
            val kelas = spinnerKelas.selectedItem.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (nim.isEmpty() || nama.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Kata sandi tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Buat objek RegisterRequest
            val credentials = RegisterRequest(
                nim = nim,
                nama = nama,
                email = email,
                no_telp = phone,
                kelas = kelas,
                password = password,
                foto_telapak_kanan = null,  // sementara null, nanti bisa diisi hasil base64 image
                foto_telapak_kiri = null
            )

            registerUser(credentials)
        }

        // Navigasi ke LoginActivity
        tvLoginRedirect.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Tombol upload telapak tangan (dummy dulu)
        btnUploadRightPalm.setOnClickListener {
            Toast.makeText(this, "Upload telapak kanan (belum aktif)", Toast.LENGTH_SHORT).show()
        }

        btnUploadLeftPalm.setOnClickListener {
            Toast.makeText(this, "Upload telapak kiri (belum aktif)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registerUser(credentials: RegisterRequest) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val call = apiService.register(credentials)

        call.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null && registerResponse.success) {
                        Toast.makeText(this@RegisterActivity, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                        // Pindah ke halaman login setelah registrasi berhasil
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@RegisterActivity, registerResponse?.message ?: "Registrasi gagal", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "Terjadi kesalahan saat registrasi", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Gagal terkoneksi dengan server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
