package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handscanattendance.R
import com.example.handscanattendance.data.Mahasiswa
import com.example.handscanattendance.data.MahasiswaAdapter
import com.example.handscanattendance.databinding.ActivityDaftarMahasiswaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DaftarMahasiswaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMahasiswaBinding
    private lateinit var mahasiswaAdapter: MahasiswaAdapter
    private var listMahasiswa = mutableListOf<Mahasiswa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupListeners()
        getMahasiswaData()
    }

    private fun setupRecyclerView() {
        mahasiswaAdapter = MahasiswaAdapter(listMahasiswa) { mahasiswa ->
            deleteMahasiswa(mahasiswa)
        }
        binding.rvMahasiswa.apply {
            layoutManager = LinearLayoutManager(this@DaftarMahasiswaActivity)
            adapter = mahasiswaAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnTambahData.setOnClickListener {
            tambahMahasiswaDummy()
        }

        binding.btnCari.setOnClickListener {
            val keyword = binding.etSearchNama.text.toString()
            cariMahasiswa(keyword)
        }
    }

    private fun getMahasiswaData() {
        // Menggunakan data dummy untuk testing
        listMahasiswa.clear()
        listMahasiswa.addAll(generateDummyData())
        mahasiswaAdapter.updateData(listMahasiswa)
    }

    private fun generateDummyData(): List<Mahasiswa> {
        return listOf(
            Mahasiswa("22013001", "John Doe", "A"),
            Mahasiswa("22013002", "Jane Doe", "B"),
            Mahasiswa("22013003", "Sam Smith", "C"),
            Mahasiswa("22013004", "Alice Johnson", "D")
        )
    }

    private fun tambahMahasiswaDummy() {
        val mahasiswaBaru = Mahasiswa("22013005", "Bob Marley", "E")
        listMahasiswa.add(mahasiswaBaru)
        mahasiswaAdapter.updateData(listMahasiswa)
    }

    private fun deleteMahasiswa(mahasiswa: Mahasiswa) {
        // Logic untuk menghapus data mahasiswa
        listMahasiswa.remove(mahasiswa)
        mahasiswaAdapter.updateData(listMahasiswa)
        Toast.makeText(this@DaftarMahasiswaActivity, "Mahasiswa berhasil dihapus", Toast.LENGTH_SHORT).show()
    }

    private fun cariMahasiswa(keyword: String) {
        val filteredList = if (keyword.isEmpty()) {
            listMahasiswa
        } else {
            listMahasiswa.filter {
                it.nama.contains(keyword, ignoreCase = true)
            }
        }
        mahasiswaAdapter.updateData(filteredList)
    }
}
