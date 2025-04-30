package com.example.handscanattendance.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R

class MahasiswaAdapter(
    private var mahasiswaList: List<Mahasiswa>,
    private val onDeleteClick: (Mahasiswa) -> Unit // Callback untuk delete
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNo: TextView = itemView.findViewById(R.id.tvNo)
        val tvNim: TextView = itemView.findViewById(R.id.tvNim)
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val tvKelas: TextView = itemView.findViewById(R.id.tvKelas)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = mahasiswaList[position]
        holder.tvNo.text = (position + 1).toString() // Nomor urut otomatis
        holder.tvNim.text = mahasiswa.nim
        holder.tvNama.text = mahasiswa.nama
        holder.tvKelas.text = mahasiswa.kelas

        // Mengatur tombol hapus
        holder.btnDelete.setOnClickListener {
            onDeleteClick(mahasiswa) // Memanggil callback onDeleteClick saat tombol delete diklik
        }
    }

    override fun getItemCount(): Int = mahasiswaList.size

    // Fungsi untuk memperbarui data pada adapter
    fun updateData(newList: List<Mahasiswa>) {
        mahasiswaList = newList
        notifyDataSetChanged()
    }
}
