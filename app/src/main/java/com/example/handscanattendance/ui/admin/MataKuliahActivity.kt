package com.example.handscanattendance.ui.admin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MataKuliah
import com.example.handscanattendance.data.MataKuliahAdapter

class MataKuliahActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MataKuliahAdapter
    private lateinit var btnTambahMk: Button
    private lateinit var spinnerTahunAjaran: Spinner
    private lateinit var spinnerSemester: Spinner

    private val allMataKuliah = mutableListOf(
        MataKuliah(
            id = "1",
            idMk = "MK001",
            nama = "Pemrograman Mobile",
            semester = "Ganjil",
            tahunAkademik = "2024/2025"
        ),
        MataKuliah(
            id = "2",
            idMk = "MK002",
            nama = "Struktur Data",
            semester = "Genap",
            tahunAkademik = "2024/2025"
        ),
        MataKuliah(
            id = "3",
            idMk = "MK003",
            nama = "Jaringan Komputer",
            semester = "Ganjil",
            tahunAkademik = "2023/2024"
        )
    )

    private val tahunAjaranList = listOf("Semua", "2022/2023", "2023/2024", "2024/2025")
    private val semesterList = listOf("Semua", "Ganjil", "Genap")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mata_kuliah)

        recyclerView = findViewById(R.id.rv_mata_kuliah)
        btnTambahMk = findViewById(R.id.btn_tambah_mk)
        spinnerTahunAjaran = findViewById(R.id.spinner_tahun_ajaran)
        spinnerSemester = findViewById(R.id.spinner_semester)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MataKuliahAdapter(allMataKuliah.toMutableList()) { mk ->
            val intent = Intent(this, MahasiswaPerMkActivity::class.java)
            intent.putExtra("id_mk", mk.id)
            intent.putExtra("nama_mk", mk.nama)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // Spinner Tahun Ajaran
        val tahunAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tahunAjaranList)
        spinnerTahunAjaran.adapter = tahunAdapter

        // Spinner Semester
        val semesterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, semesterList)
        spinnerSemester.adapter = semesterAdapter

        // Listener untuk filter data
        val filterListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                filterMataKuliah()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinnerTahunAjaran.onItemSelectedListener = filterListener
        spinnerSemester.onItemSelectedListener = filterListener

        btnTambahMk.setOnClickListener {
            val dialog = TambahMataKuliahDialogFragment { mkBaru ->
                allMataKuliah.add(mkBaru)
                filterMataKuliah()
            }
            dialog.show(supportFragmentManager, "TambahMataKuliah")
        }
    }

    private fun filterMataKuliah() {
        val selectedTahun = spinnerTahunAjaran.selectedItem.toString()
        val selectedSemester = spinnerSemester.selectedItem.toString()

        val filtered = allMataKuliah.filter {
            (selectedTahun == "Semua" || it.tahunAkademik == selectedTahun) &&
                    (selectedSemester == "Semua" || it.semester == selectedSemester)
        }

        adapter.updateData(filtered)
    }
}
