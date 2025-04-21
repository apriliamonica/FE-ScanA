package com.example.handscanattendance.ui.admin

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.handscanattendance.R

class TambahMahasiswaDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.dialog_tambah_mahasiswa, null)

        val spinnerMahasiswa: Spinner = view.findViewById(R.id.spinner_mahasiswa)

        // Dummy data mahasiswa, nanti bisa diganti dari API
        val daftarMahasiswa = listOf(
            "21304001 - Rina Lestari",
            "21304002 - Bayu Pratama",
            "21304003 - Citra Dewi"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, daftarMahasiswa)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMahasiswa.adapter = adapter

        return AlertDialog.Builder(requireContext())
            .setTitle("Tambah Mahasiswa")
            .setView(view)
            .setPositiveButton("Simpan") { _, _ ->
                val mahasiswaDipilih = spinnerMahasiswa.selectedItem.toString()
                Toast.makeText(context, "Menambahkan: $mahasiswaDipilih", Toast.LENGTH_SHORT).show()
                // TODO: kirim ke server / tambah ke list
            }
            .setNegativeButton("Batal", null)
            .create()
    }
}
