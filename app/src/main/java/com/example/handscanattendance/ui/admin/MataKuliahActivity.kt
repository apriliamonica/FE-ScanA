package com.example.handscanattendance.ui.admin

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MataKuliah

class MataKuliahActivity : AppCompatActivity() {

    private lateinit var rvMataKuliah: RecyclerView
    private lateinit var adapter: MataKuliahAdapter
    private val mataKuliahList = mutableListOf<MataKuliah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mata_kuliah)

        rvMataKuliah = findViewById(R.id.rv_mata_kuliah)
        val btnTambah: Button = findViewById(R.id.btn_tambah_mk)
        val btnKembali: Button = findViewById(R.id.btn_kembali)

        rvMataKuliah.layoutManager = LinearLayoutManager(this)
        adapter = MataKuliahAdapter(mataKuliahList)
        rvMataKuliah.adapter = adapter

        btnTambah.setOnClickListener {
            showTambahMkDialog()
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }

    private fun showTambahMkDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_tambah_mk, null)

        val spinnerSemester = view.findViewById<Spinner>(R.id.spinnerSemester)
        val edtTahunAkademik = view.findViewById<EditText>(R.id.edtTahunAkademik)
        val edtIdMk = view.findViewById<EditText>(R.id.edtIdMk)
        val edtKelas = view.findViewById<EditText>(R.id.edtKelas)
        val edtNamaMk = view.findViewById<EditText>(R.id.edtNamaMk)
        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)
        val btnBatal = view.findViewById<Button>(R.id.btnBatal)

        val semesterAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listOf("Ganjil", "Genap")
        )
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter

        val dialog = AlertDialog.Builder(this)
            .setView(view)
            .create()

        btnSimpan.setOnClickListener {
            val semester = spinnerSemester.selectedItem.toString()
            val tahunAkademik = edtTahunAkademik.text.toString()
            val idMk = edtIdMk.text.toString()
            val kelas = edtKelas.text.toString()
            val namaMk = edtNamaMk.text.toString()

            if (tahunAkademik.isNotEmpty() && idMk.isNotEmpty() && kelas.isNotEmpty() && namaMk.isNotEmpty()) {
                val fullIdMk = "$idMk-$kelas-$tahunAkademik"
                val mataKuliah = MataKuliah(
                    id = "", // sementara kosong, nanti dari server
                    idMk = fullIdMk,
                    nama = namaMk,
                    semester = semester,
                    tahunAkademik = tahunAkademik
                )

                mataKuliahList.add(mataKuliah)
                adapter.notifyItemInserted(mataKuliahList.size - 1)

                dialog.dismiss()
            } else {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }

        btnBatal.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
