package com.example.handscanattendance.ui.admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handscanattendance.R
import com.example.handscanattendance.ui.adapter.MahasiswaAdapter
import kotlinx.android.synthetic.main.activity_mahasiswa_per_mk.*

class MahasiswaPerMkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa_per_mk)

        // Contoh data mahasiswa (ubah dengan data nyata)
        val mahasiswaList = listOf(
            Mahasiswa(1, "John Doe", "12345"),
            Mahasiswa(2, "Jane Smith", "67890")
        )

        val adapter = MahasiswaAdapter(mahasiswaList)
        rvMahasiswa.layoutManager = LinearLayoutManager(this)
        rvMahasiswa.adapter = adapter
    }
}
