package com.example.handscanattendance.ui.admin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MataKuliah
import com.example.handscanattendance.data.MataKuliahAdapter
import android.widget.Button



class MataKuliahActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MataKuliahAdapter
    private lateinit var btnTambahMk: Button
    private val dummyData = mutableListOf(
        MataKuliah("MK001", "Pemrograman Mobile", "4", "2024/2025"),
        MataKuliah("MK002", "Struktur Data", "2", "2024/2025"),
        MataKuliah("MK003", "Jaringan Komputer", "3", "2023/2024")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mata_kuliah)

        recyclerView = findViewById(R.id.rv_mata_kuliah)
        btnTambahMk = findViewById(R.id.btn_tambah_mk)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MataKuliahAdapter(dummyData) { mk ->
            val intent = Intent(this, MahasiswaPerMkActivity::class.java)
            intent.putExtra("id_mk", mk.id)
            intent.putExtra("nama_mk", mk.nama)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        btnTambahMk.setOnClickListener {
            val dialog = TambahMataKuliahDialogFragment { mkBaru ->
                dummyData.add(mkBaru)
                adapter.notifyItemInserted(dummyData.size - 1)
            }
            dialog.show(supportFragmentManager, "TambahMataKuliah")
        }
    }
}

