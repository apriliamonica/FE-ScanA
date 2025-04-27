package com.example.handscanattendance.ui.admin

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.handscanattendance.R

class TambahMataKuliahDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_tambah_mata_kuliah, null)

        val namaMataKuliahEditText: EditText = view.findViewById(R.id.et_nama_mk)
        val semesterEditText: EditText = view.findViewById(R.id.et_semester)
        val tahunAkademikEditText: EditText = view.findViewById(R.id.et_tahun_akademik)
        val btnSave: Button = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val namaMataKuliah = namaMataKuliahEditText.text.toString()
            val semester = semesterEditText.text.toString()
            val tahunAkademik = tahunAkademikEditText.text.toString()

            if (namaMataKuliah.isNotEmpty() && semester.isNotEmpty() && tahunAkademik.isNotEmpty()) {
                // Implementasi logika untuk menyimpan data mata kuliah
                // Misalnya, panggil API atau simpan ke database lokal
            }
        }

        dialog.setContentView(view)
        return dialog
    }
}
