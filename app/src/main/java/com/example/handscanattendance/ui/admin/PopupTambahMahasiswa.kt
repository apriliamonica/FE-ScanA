package com.example.handscanattendance.ui.admin

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.handscanattendance.R

class PopupTambahMahasiswa(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_tambah_mahasiswa)

        val btnTambah = findViewById<Button>(R.id.btn_tambah)
        val btnClose = findViewById<ImageView>(R.id.btn_close)

        btnClose.setOnClickListener { dismiss() }

        btnTambah.setOnClickListener {
            // Tambahkan logika tambah mahasiswa di sini
            dismiss()
        }
    }
}
