package com.example.handscanattendance.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R

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
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this, "Kata sandi tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi lainnya bisa ditambah di sini

            // Nanti di sini kamu bisa panggil API Register

            Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

            // Pindah ke halaman login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
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
}
