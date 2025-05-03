package com.example.handscanattendance.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.Mahasiswa

class MahasiswaPilihAdapter(
    private val listMahasiswa: List<Mahasiswa>
) : RecyclerView.Adapter<MahasiswaPilihAdapter.MahasiswaViewHolder>() {

    // Menyimpan mahasiswa yang dicentang
    private val selectedMahasiswa = mutableSetOf<Mahasiswa>()

    inner class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNim: TextView = itemView.findViewById(R.id.tvNim)
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val cbPilih: CheckBox = itemView.findViewById(R.id.cbPilih)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa_pilih, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]
        holder.tvNim.text = mahasiswa.nim
        holder.tvNama.text = mahasiswa.nama
        holder.cbPilih.setOnCheckedChangeListener(null)
        holder.cbPilih.isChecked = selectedMahasiswa.contains(mahasiswa)

        holder.cbPilih.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedMahasiswa.add(mahasiswa)
            } else {
                selectedMahasiswa.remove(mahasiswa)
            }
        }
    }

    override fun getItemCount(): Int = listMahasiswa.size

    fun getMahasiswaTerpilih(): List<Mahasiswa> = selectedMahasiswa.toList()
}
