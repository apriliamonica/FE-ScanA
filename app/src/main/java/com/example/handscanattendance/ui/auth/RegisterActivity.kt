package com.example.handscanattendance.ui.auth

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.RegisterRequest
import com.example.handscanattendance.network.ApiService
import com.example.handscanattendance.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import android.util.Base64
import com.example.handscanattendance.data.model.RegisterResponse

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

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

    private var rightPalmBitmap: Bitmap? = null
    private var leftPalmBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initViews()
        setupListeners()
    }

    private fun initViews() {
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
    }

    private fun setupListeners() {
        btnUploadRightPalm.setOnClickListener { openCamera(CAMERA_REQUEST_CODE_RIGHT) }
        btnUploadLeftPalm.setOnClickListener { openCamera(CAMERA_REQUEST_CODE_LEFT) }

        btnRegister.setOnClickListener {
            val nim = etNIM.text.toString()
            val nama = etNama.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (nim.isEmpty() || nama.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
            } else {
                val palmLeftBase64 = convertBitmapToBase64(leftPalmBitmap)
                val palmRightBase64 = convertBitmapToBase64(rightPalmBitmap)

                val registerRequest = RegisterRequest(nim, nama, email, phone, password, palmLeftBase64, palmRightBase64)

                lifecycleScope.launch {
                    try {
                        val response = RetrofitClient.apiService.register(registerRequest)
                        if (response.isSuccessful) {
                            Toast.makeText(this@RegisterActivity, "Berhasil Daftar!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@RegisterActivity, "Registrasi Gagal!", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this@RegisterActivity, "Terjadi Kesalahan!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        tvLoginRedirect.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun convertBitmapToBase64(bitmap: Bitmap?): String {
        val outputStream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val byteArray = outputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    private fun openCamera(requestCode: Int) {
        val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            val photo = data.extras?.get("data") as Bitmap
            when (requestCode) {
                CAMERA_REQUEST_CODE_LEFT -> {
                    leftPalmBitmap = photo
                    btnUploadLeftPalm.text = "Foto Kiri Tangan Terambil"
                }
                CAMERA_REQUEST_CODE_RIGHT -> {
                    rightPalmBitmap = photo
                    btnUploadRightPalm.text = "Foto Kanan Tangan Terambil"
                }
            }
        }
    }

    companion object {
        private const val CAMERA_REQUEST_CODE_LEFT = 101
        private const val CAMERA_REQUEST_CODE_RIGHT = 102
    }
}
