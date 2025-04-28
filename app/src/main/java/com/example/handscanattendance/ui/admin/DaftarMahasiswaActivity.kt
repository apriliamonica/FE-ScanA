package com.example.handscanattendance.ui.admin

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.MahasiswaModel
import com.example.handscanattendance.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarMahasiswaActivity : AppCompatActivity() {

    private lateinit var spinnerMk: Spinner
    private lateinit var etSearchNama: EditText
    private lateinit var btnCari: Button
    private lateinit var btnTambahData: Button
    private lateinit var rvMahasiswa: androidx.recyclerview.widget.RecyclerView
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    private var listMahasiswa = mutableListOf<MahasiswaModel>()
    private var filteredMahasiswa = mutableListOf<MahasiswaModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_mahasiswa)

        initViews()
        setupSpinner()
        setupRecyclerView()
        setupListeners()

        // Ambil data mahasiswa dari backend
        loadMahasiswa()
    }

    private fun initViews() {
        spinnerMk = findViewById(R.id.spinnerMk)
        etSearchNama = findViewById(R.id.etSearchNama)
        btnCari = findViewById(R.id.btnCari)
        btnTambahData = findViewById(R.id.btnTambahData)
        rvMahasiswa = findViewById(R.id.rvMahasiswa)
    }

    private fun setupSpinner() {
        val listMk = listOf("Pilih Mata Kuliah", "Pemrograman Android", "Kecerdasan Buatan", "Basis Data Lanjut")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listMk)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMk.adapter = adapter
    }

    private fun setupRecyclerView() {
        mahasiswaAdapter = MahasiswaAdapter(filteredMahasiswa) { mahasiswa -> showDeleteDialog(mahasiswa) }
        rvMahasiswa.layoutManager = LinearLayoutManager(this)
        rvMahasiswa.adapter = mahasiswaAdapter
    }

    private fun setupListeners() {
        btnCari.setOnClickListener { filterMahasiswa() }
        btnTambahData.setOnClickListener { showTambahMahasiswaDialog() }
    }

    private fun loadMahasiswa() {
        lifecycleScope.launch {
            try {
                val mahasiswaList = RetrofitClient.apiService.getMahasiswa()
                listMahasiswa.clear()
                listMahasiswa.addAll(mahasiswaList)
                filterMahasiswa()
            } catch (e: Exception) {
                Toast.makeText(this@DaftarMahasiswaActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun filterMahasiswa() {
        val namaInput = etSearchNama.text.toString().trim()
        filteredMahasiswa.clear()
        if (namaInput.isEmpty()) {
            filteredMahasiswa.addAll(listMahasiswa)
        } else {
            filteredMahasiswa.addAll(listMahasiswa.filter { it.nama.contains(namaInput, ignoreCase = true) })
        }
        mahasiswaAdapter.notifyDataSetChanged()
    }

    private fun showDeleteDialog(mahasiswa: MahasiswaModel) {
        AlertDialog.Builder(this)
            .setTitle("Hapus Mahasiswa")
            .setMessage("Apakah Anda yakin ingin menghapus ${mahasiswa.nama}?")
            .setPositiveButton("Ya") { _, _ ->
                listMahasiswa.remove(mahasiswa)
                filterMahasiswa()
                Toast.makeText(this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    private fun showTambahMahasiswaDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_tambah_mahasiswa, null)
        val dialog = Dialog(this)
        dialog.setContentView(dialogView)

        val etNim = dialogView.findViewById<EditText>(R.id.etNIM)
        val etNama = dialogView.findViewById<EditText>(R.id.etNama)
        val etPassword = dialogView.findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = dialogView.findViewById<EditText>(R.id.etConfirmPassword)
        val etEmail = dialogView.findViewById<EditText>(R.id.etEmail)
        val etPhone = dialogView.findViewById<EditText>(R.id.etPhone)

        val btnTambah = dialogView.findViewById<Button>(R.id.btnRegister)

        btnTambah.setOnClickListener {
            val nim = etNim.text.toString()
            val nama = etNama.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()

            if (nim.isEmpty() || nama.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
            } else {
                val mahasiswa = MahasiswaModel(nim, nama, password, email, phone)

                lifecycleScope.launch {
                    try {
                        val response = RetrofitClient.apiService.addMahasiswa(mahasiswa)
                        if (response.isSuccessful) {
                            loadMahasiswa()  // Setelah mahasiswa ditambahkan, load ulang data
                            dialog.dismiss()
                        } else {
                            Toast.makeText(this@DaftarMahasiswaActivity, "Gagal menambahkan mahasiswa", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this@DaftarMahasiswaActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        dialog.show()
    }
}
