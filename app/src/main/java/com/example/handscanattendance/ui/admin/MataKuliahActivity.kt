package com.example.handscanattendance.ui.admin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.MataKuliah
import com.example.handscanattendance.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MataKuliahActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MataKuliahAdapter
    private val daftarMk = mutableListOf<MataKuliah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mata_kuliah)

        recyclerView = findViewById(R.id.rv_mata_kuliah)
        val btnTambahMk: Button = findViewById(R.id.btn_tambah_mk)

        adapter = MataKuliahAdapter(daftarMk) { mk ->
            val intent = Intent(this, MahasiswaPerMKActivity::class.java)
            intent.putExtra("idMk", mk.idMk)
            intent.putExtra("namaMk", mk.namaMk)
            intent.putExtra("kelas", mk.kelas)
            intent.putExtra("semester", mk.semester)
            intent.putExtra("tahunAkademik", mk.tahunAkademik)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnTambahMk.setOnClickListener {
            tampilkanDialogTambahMk()
        }

        loadMataKuliah()
    }

    private fun loadMataKuliah() {
        ApiClient.instance.getMataKuliah().enqueue(object : Callback<List<MataKuliah>> {
            override fun onResponse(call: Call<List<MataKuliah>>, response: Response<List<MataKuliah>>) {
                if (response.isSuccessful) {
                    daftarMk.clear()
                    daftarMk.addAll(response.body() ?: emptyList())
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MataKuliahActivity, "Gagal memuat data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<MataKuliah>>, t: Throwable) {
                Toast.makeText(this@MataKuliahActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun tampilkanDialogTambahMk() {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_tambah_mk, null)
        val dialog = AlertDialog.Builder(this).setView(view).create()

        val edtIdMk = view.findViewById<EditText>(R.id.edtIdMk)
        val edtNamaMk = view.findViewById<EditText>(R.id.edtNamaMk)
        val edtKelas = view.findViewById<EditText>(R.id.edtKelas)
        val spinnerSemester = view.findViewById<Spinner>(R.id.spinnerSemester)
        val edtTahunAkademik = view.findViewById<EditText>(R.id.edtTahunAkademik)
        val btnBatal = view.findViewById<Button>(R.id.btnBatal)
        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)

        val semesterList = listOf("Ganjil", "Genap")
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, semesterList)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = adapterSpinner

        btnSimpan.setOnClickListener {
            val idMk = edtIdMk.text.toString()
            val namaMk = edtNamaMk.text.toString()
            val kelas = edtKelas.text.toString()
            val semester = spinnerSemester.selectedItem.toString()
            val tahunAkademik = edtTahunAkademik.text.toString()

            // Validasi input
            if (idMk.isBlank() || namaMk.isBlank() || kelas.isBlank() || tahunAkademik.isBlank()) {
                Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi format tahun akademik
            val tahunRegex = Regex("\\d{4}/\\d{4}")
            if (!tahunRegex.matches(tahunAkademik)) {
                Toast.makeText(this, "Format Tahun Akademik harus ####/####", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cek duplikat ID
            if (daftarMk.any { it.idMk == idMk }) {
                Toast.makeText(this, "ID Mata Kuliah sudah ada", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val mk = MataKuliah(idMk, namaMk, kelas, semester, tahunAkademik)

            ApiClient.instance.tambahMataKuliah(mk).enqueue(object : Callback<MataKuliah> {
                override fun onResponse(call: Call<MataKuliah>, response: Response<MataKuliah>) {
                    if (response.isSuccessful) {
                        daftarMk.add(mk)
                        adapter.notifyItemInserted(daftarMk.size - 1)
                        Toast.makeText(this@MataKuliahActivity, "Berhasil disimpan", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    } else {
                        Toast.makeText(this@MataKuliahActivity, "Gagal simpan: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<MataKuliah>, t: Throwable) {
                    Toast.makeText(this@MataKuliahActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btnBatal.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
