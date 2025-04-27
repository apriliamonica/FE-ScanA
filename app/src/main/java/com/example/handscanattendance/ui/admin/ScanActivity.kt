package com.example.handscanattendance.ui.admin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.handscanattendance.R

class ScanActivity : AppCompatActivity() {

    private lateinit var textureView: TextureView
    private lateinit var captureButton: ImageButton
    private lateinit var scanText: TextView

    private val CAMERA_PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        textureView = findViewById(R.id.textureView)
        captureButton = findViewById(R.id.captureButton)
        scanText = findViewById(R.id.scanText)

        // Periksa izin kamera
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Jika izin belum diberikan, meminta izin
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
        } else {
            // Izin sudah diberikan, lanjutkan proses lainnya
            initCamera()
        }

        // Munculkan text "memindai..." saat kamera aktif
        showScanText()

        captureButton.setOnClickListener {
            // Setelah capture, hilangkan text
            hideScanText()
        }
    }

    // Fungsi untuk inisialisasi kamera (misalnya membuka kamera)
    private fun initCamera() {
        // Logika untuk memulai pemindaian dengan kamera di sini
        Toast.makeText(this, "Kamera siap digunakan", Toast.LENGTH_SHORT).show()
    }

    private fun showScanText() {
        scanText.visibility = View.VISIBLE
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 500
        scanText.startAnimation(fadeIn)
    }

    private fun hideScanText() {
        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.duration = 500
        fadeOut.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}
            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                scanText.visibility = View.GONE
            }
            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
        })
        scanText.startAnimation(fadeOut)
    }

    // Menangani hasil permintaan izin kamera
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Izin diberikan, inisialisasi kamera
                    initCamera()
                    Toast.makeText(this, "Izin Kamera Diberikan", Toast.LENGTH_SHORT).show()
                } else {
                    // Izin ditolak
                    Toast.makeText(this, "Izin Kamera Ditolak", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
