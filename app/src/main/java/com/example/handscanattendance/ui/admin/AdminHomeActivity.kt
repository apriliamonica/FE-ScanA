package com.example.handscanattendance.ui.admin

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.handscanattendance.R
import com.example.handscanattendance.ui.admin.AdminHomeActivity
import com.example.handscanattendance.ui.auth.LoginActivity
import android.Manifest
import android.widget.Toast

class AdminHomeActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast("Permission request granted")
            } else {
                showToast("Permission request denied")
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

        val logoutButton: ImageButton = findViewById(R.id.logout_button)
        val scanButton: Button = findViewById(R.id.scan_button)
        val scheduleButton: Button = findViewById(R.id.schedule_button)
        val studentListButton: Button = findViewById(R.id.student_list_button)
        val courseButton: Button = findViewById(R.id.course_button)
        val attendanceHistoryButton: Button = findViewById(R.id.attendance_history_button)

        if(!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        // Logout
        logoutButton.setOnClickListener {
            // Kembali ke halaman login (misal LoginActivity)
            val intent = Intent(this, com.example.handscanattendance.ui.auth.LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Navigasi ke halaman-halaman fitur admin
        scanButton.setOnClickListener {
            startActivity(Intent(this, ScanActivity::class.java))
        }

        scheduleButton.setOnClickListener {
            startActivity(Intent(this, JadwalActivity::class.java))
        }

        studentListButton.setOnClickListener {
            startActivity(Intent(this, DaftarMahasiswaActivity::class.java))
        }

        courseButton.setOnClickListener {
            startActivity(Intent(this, MataKuliahActivity::class.java))
        }

        attendanceHistoryButton.setOnClickListener {
            startActivity(Intent(this, RiwayatKehadiranActivity::class.java))
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}
