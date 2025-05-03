package com.example.handscanattendance.ui.admin

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.Jadwal
import com.example.handscanattendance.data.model.Mahasiswa
import com.example.handscanattendance.databinding.ActivityMahasiswaPerMkBinding

class MahasiswaPerMKActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMahasiswaPerMkBinding
    private val daftarMahasiswa = mutableListOf<Mahasiswa>()
    private val daftarJadwal = mutableListOf<Jadwal>()
    private lateinit var mahasiswaAdapter: MahasiswaAdapter
    private lateinit var jadwalAdapter: JadwalAdapter
    private var tabAktif = "mahasiswa"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaPerMkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi adapter dengan fungsi hapus
        mahasiswaAdapter = MahasiswaAdapter(daftarMahasiswa) { mahasiswa ->
            daftarMahasiswa.remove(mahasiswa)
            mahasiswaAdapter.notifyDataSetChanged()
            Toast.makeText(this, "${mahasiswa.nama} dihapus", Toast.LENGTH_SHORT).show()
        }

        jadwalAdapter = JadwalAdapter(daftarJadwal)

        // Setup RecyclerViews
        binding.rvMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.rvMahasiswa.adapter = mahasiswaAdapter
        binding.rvJadwal.layoutManager = LinearLayoutManager(this)
        binding.rvJadwal.adapter = jadwalAdapter

        // Simulasi data awal
        tambahDataDummy()

        // Tombol kembali
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Tab Mahasiswa
        binding.btnMahasiswa.setOnClickListener {
            tabAktif = "mahasiswa"
            binding.rvMahasiswa.visibility = View.VISIBLE
            binding.rvJadwal.visibility = View.GONE
            binding.btnMahasiswa.setBackgroundTintList(getColorStateList(R.color.yellow))
            binding.btnJadwal.setBackgroundTintList(getColorStateList(R.color.light_gray))
        }

        // Tab Jadwal
        binding.btnJadwal.setOnClickListener {
            tabAktif = "jadwal"
            binding.rvMahasiswa.visibility = View.GONE
            binding.rvJadwal.visibility = View.VISIBLE
            binding.btnMahasiswa.setBackgroundTintList(getColorStateList(R.color.light_gray))
            binding.btnJadwal.setBackgroundTintList(getColorStateList(R.color.yellow))
        }

        // Tombol Tambah
        binding.btnTambah.setOnClickListener {
            if (tabAktif == "mahasiswa") {
                tampilkanDialogTambahMahasiswa()
            } else {
                tampilkanDialogTambahJadwal()
            }
        }
    }

    private fun tambahDataDummy() {
        daftarMahasiswa.add(Mahasiswa("12345", "Budi Santoso", "Aktif"))
        daftarMahasiswa.add(Mahasiswa("67890", "Siti Aminah", "Aktif"))
        mahasiswaAdapter.notifyDataSetChanged()

        daftarJadwal.add(Jadwal(1, "Senin, 01 Jan 2025", "08:00", "09:40"))
        daftarJadwal.add(Jadwal(2, "Rabu, 03 Jan 2025", "10:00", "11:33"))
        jadwalAdapter.notifyDataSetChanged()
    }

    private fun tampilkanDialogTambahMahasiswa() {
        AlertDialog.Builder(this)
            .setTitle("Tambah Mahasiswa")
            .setMessage("Implementasikan form dialog_tambah_mahasiswa.xml di sini.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun tampilkanDialogTambahJadwal() {
        AlertDialog.Builder(this)
            .setTitle("Tambah Jadwal")
            .setMessage("Implementasikan form tambah jadwal di sini.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
