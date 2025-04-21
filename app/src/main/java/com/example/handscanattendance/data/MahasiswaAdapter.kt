package com.example.handscanattendance.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.Mahasiswa

class MahasiswaAdapter(private val list: List<Mahasiswa>) :
    RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNim: TextView = view.findViewById(R.id.tv_nim)
        val tvNama: TextView = view.findViewById(R.id.tv_nama)
        val tvKelas: TextView = view.findViewById(R.id.tv_kelas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa_per_mk, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mhs = list[position]
        holder.tvNim.text = mhs.nim
        holder.tvNama.text = mhs.nama
        holder.tvKelas.text = mhs.kelas
    }
}
