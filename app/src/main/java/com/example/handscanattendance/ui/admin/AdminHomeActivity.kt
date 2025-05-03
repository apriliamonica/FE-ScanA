package com.example.handscanattendance.ui.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.handscanattendance.R
import com.example.handscanattendance.ui.auth.LoginActivity
import android.Manifest
import android.content.pm.PackageManager
import android.widget.ImageView

class AdminHomeActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast("Permission granted")
            } else {
                showToast("Permission denied")
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)

        // Memeriksa izin kamera saat activity dibuka
        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        val scanButton: Button = findViewById(R.id.scan_button)
        val logoutButton: ImageView = findViewById(R.id.logout_button)
        val courseButton: Button = findViewById(R.id.course_button)

        // Logic untuk logout
        logoutButton.setOnClickListener {
            // Mengembalikan ke halaman login
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Navigasi ke halaman-halaman fitur admin
        scanButton.setOnClickListener {
            startActivity(Intent(this, ScanActivity::class.java))
        }

        courseButton.setOnClickListener {
            startActivity(Intent(this, MataKuliahActivity::class.java))
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}
