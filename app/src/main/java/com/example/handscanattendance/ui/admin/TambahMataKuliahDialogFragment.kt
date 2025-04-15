package com.example.handscanattendance.ui.admin

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MataKuliah

class TambahMataKuliahDialogFragment(
    private val onMataKuliahAdded: (MataKuliah) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.dialog_tambah_mata_kuliah, null)

        val etSemester = view.findViewById<EditText>(R.id.et_semester)
        val etIdMk = view.findViewById<EditText>(R.id.et_id_mk)
        val etNamaMk = view.findViewById<EditText>(R.id.et_nama_mk)
        val etTahunAkademik = view.findViewById<EditText>(R.id.et_tahun_akademik)

        return AlertDialog.Builder(requireContext())
            .setTitle("Tambah Mata Kuliah")
            .setView(view)
            .setPositiveButton("Simpan", null) // kita override di bawah
            .setNegativeButton("Batal", null)
            .create()
            .also { dialog ->
                dialog.setOnShowListener {
                    val simpanButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    simpanButton.setOnClickListener {
                        val id = etIdMk.text.toString()
                        val nama = etNamaMk.text.toString()
                        val semester = etSemester.text.toString()
                        val tahunAkademik = etTahunAkademik.text.toString()

                        if (id.isBlank() || nama.isBlank() || semester.isBlank() || tahunAkademik.isBlank()) {
                            Toast.makeText(requireContext(), "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }

                        val mataKuliah = MataKuliah(id, nama, semester, tahunAkademik)
                        onMataKuliahAdded(mataKuliah)
                        dialog.dismiss()
                    }
                }
            }
    }
}
