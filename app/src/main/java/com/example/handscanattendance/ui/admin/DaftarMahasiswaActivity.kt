package com.example.handscanattendance.data

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handscanattendance.R
import com.example.handscanattendance.databinding.ActivityDaftarMahasiswaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

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
        loadDataMahasiswa() // Ambil data dari backend saat activity dimulai
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
            tambahMahasiswaDummy()  // Ganti ini untuk membuka form input data mahasiswa
        }

        binding.btnCari.setOnClickListener {
            val keyword = binding.etSearchNama.text.toString()
            cariMahasiswa(keyword)
        }
    }

    private fun loadDataMahasiswa() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response<List<Mahasiswa>> = ApiClient.apiService.getMahasiswaList()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        listMahasiswa = response.body()?.toMutableList() ?: mutableListOf()
                        mahasiswaAdapter.updateData(listMahasiswa)
                    } else {
                        // Tangani error jika API gagal
                        Toast.makeText(this@DaftarMahasiswaActivity, "Gagal memuat data", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@DaftarMahasiswaActivity, "Terjadi kesalahan jaringan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun tambahMahasiswaDummy() {
        // Ganti dengan input form untuk menambah mahasiswa baru
        val no = listMahasiswa.size + 1
        val newMahasiswa = Mahasiswa(no, "NIM00$no", "Mahasiswa $no", "A")
        tambahMahasiswaKeBackend(newMahasiswa)
    }

    private fun tambahMahasiswaKeBackend(mahasiswa: Mahasiswa) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = ApiClient.apiService.addMahasiswa(mahasiswa)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        listMahasiswa.add(mahasiswa)
                        mahasiswaAdapter.updateData(listMahasiswa)
                    } else {
                        // Tangani error jika API gagal
                        Toast.makeText(this@DaftarMahasiswaActivity, "Gagal menambah mahasiswa", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@DaftarMahasiswaActivity, "Terjadi kesalahan jaringan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun deleteMahasiswa(mahasiswa: Mahasiswa) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = ApiClient.apiService.deleteMahasiswa(mahasiswa.no)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        listMahasiswa.remove(mahasiswa)
                        mahasiswaAdapter.updateData(listMahasiswa)
                    } else {
                        // Tangani error jika API gagal
                        Toast.makeText(this@DaftarMahasiswaActivity, "Gagal menghapus mahasiswa", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@DaftarMahasiswaActivity, "Terjadi kesalahan jaringan", Toast.LENGTH_SHORT).show()
                }
            }
        }
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
