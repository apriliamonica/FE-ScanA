package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R

class JadwalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_perkuliahan)

        val btnKembali: Button = findViewById(R.id.btn_kembali)
        val btnTambah: Button = findViewById(R.id.btn_tambah)

        btnKembali.setOnClickListener {
            finish() // kembali ke halaman sebelumnya
        }

        btnTambah.setOnClickListener {
            // Nanti munculin dialog atau pindah ke BuatJadwalActivity
            // Contoh sementara:
            // startActivity(Intent(this, BuatJadwalActivity::class.java))
        }
    }
}
