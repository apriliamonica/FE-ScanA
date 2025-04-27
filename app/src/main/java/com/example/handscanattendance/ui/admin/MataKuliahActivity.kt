package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MataKuliahAdapter


data class MataKuliah(
    val idMK: String,
    val namaMK: String,
    val semester: String
)

class MataKuliahActivity : AppCompatActivity() {

    private lateinit var btnKembali: Button
    private lateinit var btnTambahMK: Button
    private lateinit var edtSearch: EditText
    private lateinit var rvMataKuliah: RecyclerView
    private lateinit var mataKuliahAdapter: MataKuliahAdapter

    private val listMataKuliah = mutableListOf<MataKuliah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mata_kuliah)

        btnKembali = findViewById(R.id.btn_kembali)
        btnTambahMK = findViewById(R.id.btn_tambah_mk)
        edtSearch = findViewById(R.id.edt_search)
        rvMataKuliah = findViewById(R.id.rv_mata_kuliah)

        setupRecyclerView()

        btnTambahMK.setOnClickListener {
            showTambahMKDialog()
        }

        btnKembali.setOnClickListener {
            finish()
        }

        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterMataKuliah(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setupRecyclerView() {
        mataKuliahAdapter = MataKuliahAdapter(listMataKuliah)
        rvMataKuliah.layoutManager = LinearLayoutManager(this)
        rvMataKuliah.adapter = mataKuliahAdapter
    }

    private fun filterMataKuliah(query: String) {
        val filteredList = listMataKuliah.filter {
            it.namaMK.contains(query, ignoreCase = true)
        }
        mataKuliahAdapter.updateList(filteredList)
    }

    private fun showTambahMKDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_tambah_mk, null)

        val edtIdMK = view.findViewById<EditText>(R.id.edt_id_mk)
        val edtNamaMK = view.findViewById<EditText>(R.id.edt_nama_mk)
        val edtSemester = view.findViewById<EditText>(R.id.edt_semester)

        AlertDialog.Builder(this)
            .setView(view)
            .setTitle("Tambah Mata Kuliah")
            .setPositiveButton("Simpan") { dialog, _ ->
                val idMK = edtIdMK.text.toString()
                val namaMK = edtNamaMK.text.toString()
                val semester = edtSemester.text.toString()

                if (idMK.isNotEmpty() && namaMK.isNotEmpty() && semester.isNotEmpty()) {
                    listMataKuliah.add(MataKuliah(idMK, namaMK, semester))
                    mataKuliahAdapter.updateList(listMataKuliah)
                } else {
                    Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Batal") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
