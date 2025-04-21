package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.Mahasiswa
import com.example.handscanattendance.data.MahasiswaAdapter

import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MahasiswaPerMkActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnTambah: Button
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa_per_mk)

        recyclerView = findViewById(R.id.rv_mahasiswa)
        btnTambah = findViewById(R.id.btn_tambah_mahasiswa)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dummyMahasiswa = listOf(
            Mahasiswa("21304001", "Rina Lestari", "TI-4A"),
            Mahasiswa("21304002", "Bayu Pratama", "TI-4A"),
            Mahasiswa("21304003", "Citra Dewi", "TI-4B")
        )

        adapter = MahasiswaAdapter(dummyMahasiswa)
        recyclerView.adapter = adapter

        btnTambah.setOnClickListener {
            val dialog = TambahMahasiswaDialogFragment()
            dialog.show(supportFragmentManager, "TambahMahasiswa")
        }
    }
}
