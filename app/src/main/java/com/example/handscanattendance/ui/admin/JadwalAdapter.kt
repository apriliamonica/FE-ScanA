package com.example.handscanattendance.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.Jadwal

class JadwalAdapter(private val daftarJadwal: List<Jadwal>) :
    RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>() {

    class JadwalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPertemuan: TextView = itemView.findViewById(R.id.tvPertemuan)
        val tvTanggal: TextView = itemView.findViewById(R.id.tvTanggal)
        val tvJamMasuk: TextView = itemView.findViewById(R.id.tvJamMasuk)
        val tvJamKeluar: TextView = itemView.findViewById(R.id.tvJamKeluar)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jadwal, parent, false)
        return JadwalViewHolder(view)
    }

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        val jadwal = daftarJadwal[position]
        holder.tvPertemuan.text = jadwal.pertemuan.toString()
        holder.tvTanggal.text = jadwal.tanggal
        holder.tvJamMasuk.text = jadwal.jamMasuk
        holder.tvJamKeluar.text = jadwal.jamKeluar

        holder.btnDelete.setOnClickListener {
            // Tambahkan logika hapus kalau diperlukan
        }
    }

    override fun getItemCount(): Int = daftarJadwal.size
}
