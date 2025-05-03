package com.example.handscanattendance.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.Mahasiswa

class MahasiswaAdapter(
    private val listMahasiswa: List<Mahasiswa>,
    private val onDeleteClick: (Mahasiswa) -> Unit
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNim: TextView = itemView.findViewById(R.id.tvNim)
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]
        holder.tvNim.text = mahasiswa.nim
        holder.tvNama.text = mahasiswa.nama
        holder.tvStatus.text = mahasiswa.status

        holder.btnDelete.setOnClickListener {
            onDeleteClick(mahasiswa)
        }
    }

    override fun getItemCount(): Int = listMahasiswa.size
}
