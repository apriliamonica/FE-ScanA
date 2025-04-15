package com.example.handscanattendance.ui.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R

class AdminHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)

        val logoutButton: ImageButton = findViewById(R.id.logout_button)
        val scanButton: Button = findViewById(R.id.scan_button)
        val scheduleButton: Button = findViewById(R.id.schedule_button)
        val studentListButton: Button = findViewById(R.id.student_list_button)
        val courseButton: Button = findViewById(R.id.course_button)
        val attendanceHistoryButton: Button = findViewById(R.id.attendance_history_button)

        // Logout
        logoutButton.setOnClickListener {
            // Kembali ke halaman login (misal LoginActivity)
            val intent = Intent(this, com.example.handscanattendance.ui.LoginActivity::class.java)
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
            startActivity(Intent(this, MahasiswaActivity::class.java))
        }

        courseButton.setOnClickListener {
            startActivity(Intent(this, MataKuliahActivity::class.java))
        }

        attendanceHistoryButton.setOnClickListener {
            startActivity(Intent(this, RiwayatKehadiranActivity::class.java))
        }
    }
}
