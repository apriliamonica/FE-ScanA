package com.example.handscanattendance.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.MahasiswaModel

class MahasiswaAdapter(
    private var listMahasiswa: List<MahasiswaModel>,
    private val onDeleteClick: (MahasiswaModel) -> Unit
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNo: TextView = itemView.findViewById(R.id.tvNo)
        val tvNim: TextView = itemView.findViewById(R.id.tvNim)
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val btnHapus: Button = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]
        holder.tvNo.text = (position + 1).toString()
        holder.tvNim.text = mahasiswa.nim
        holder.tvNama.text = mahasiswa.nama

        holder.btnHapus.setOnClickListener {
            onDeleteClick(mahasiswa)
        }
    }

    override fun getItemCount(): Int = listMahasiswa.size

    fun updateList(newList: List<MahasiswaModel>) {
        listMahasiswa = newList
        notifyDataSetChanged()
    }
}
