package com.example.handscanattendance.data

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R

class MahasiswaAdapter(private val list: MutableList<MahasiswaModel>) :
    RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNim: TextView = view.findViewById(R.id.tv_nim)
        val tvNama: TextView = view.findViewById(R.id.tv_nama)
        val tvKelas: TextView = view.findViewById(R.id.tv_kelas)
        val btnHapus: Button = view.findViewById(R.id.btn_hapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mahasiswa = list[position]

        holder.tvNim.text = mahasiswa.nim
        holder.tvNama.text = mahasiswa.nama
        holder.tvKelas.text = mahasiswa.kelas

        holder.btnHapus.setOnClickListener {
            showDeleteDialog(holder.itemView.context, position)
        }
    }

    override fun getItemCount(): Int = list.size

    private fun showDeleteDialog(context: Context, position: Int) {
        AlertDialog.Builder(context)
            .setTitle("Konfirmasi Hapus")
            .setMessage("Apakah Anda yakin ingin menghapus mahasiswa ini?")
            .setPositiveButton("Ya") { _, _ ->
                list.removeAt(position)
                notifyItemRemoved(position)
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}
