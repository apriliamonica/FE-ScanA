//package com.example.handscanattendance.ui.mahasiswa
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.handscanattendance.R
//import com.example.handscanattendance.databinding.ActivityRiwayatKehadiranMahasiswaBinding
//import com.example.handscanattendance.model.Kehadiran
//import com.example.handscanattendance.ui.adapter.KehadiranAdapter
//
//class RiwayatKehadiranMahasiswaActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityRiwayatKehadiranMahasiswaBinding
//    private lateinit var adapter: KehadiranAdapter
//    private val riwayatList = mutableListOf<Kehadiran>() // Data dummy
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRiwayatKehadiranMahasiswaBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setupRecyclerView()
//        loadDummyData()
//
//        binding.btnBack.setOnClickListener {
//            finish()
//        }s
//    }
//
//    private fun setupRecyclerView() {
//        adapter = KehadiranAdapter(riwayatList)
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@RiwayatKehadiranMahasiswaActivity)
//            adapter = this@RiwayatKehadiranMahasiswaActivity.adapter
//        }
//    }
//
//    private fun loadDummyData() {
//        // Simulasi data riwayat kehadiran mahasiswa
//        riwayatList.add(Kehadiran("Pertemuan 1", "01/03/2025", "Hadir"))
//        riwayatList.add(Kehadiran("Pertemuan 2", "08/03/2025", "Tidak Hadir"))
//        riwayatList.add(Kehadiran("Pertemuan 3", "15/03/2025", "Hadir"))
//
//        adapter.notifyDataSetChanged()
//    }
//}
