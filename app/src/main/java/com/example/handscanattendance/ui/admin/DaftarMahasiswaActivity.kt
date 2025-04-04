package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MahasiswaAdapter
import com.example.handscanattendance.data.MahasiswaModel

class DaftarMahasiswaActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MahasiswaAdapter
    private val mahasiswaList = mutableListOf<MahasiswaModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_mahasiswa)

        val btnTambah = findViewById<Button>(R.id.btn_tambah_mahasiswa)
        recyclerView = findViewById(R.id.recyclerView)

        btnTambah.setOnClickListener {
            val popup = PopupTambahMahasiswa(this)
            popup.show()
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MahasiswaAdapter(mahasiswaList)
        recyclerView.adapter = adapter
    }
}
