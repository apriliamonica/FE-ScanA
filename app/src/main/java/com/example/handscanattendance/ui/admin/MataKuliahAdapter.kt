package com.example.handscanattendance.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.model.MataKuliah

class MataKuliahAdapter(
    private val listMk: List<MataKuliah>,
    private val onItemClick: (MataKuliah) -> Unit
) : RecyclerView.Adapter<MataKuliahAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNamaMk: TextView = view.findViewById(R.id.edtNamaMk)
        val txtKelas: TextView = view.findViewById(R.id.edtKelas)

        init {
            view.setOnClickListener {
                onItemClick(listMk[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mata_kuliah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mk = listMk[position]
        // Menampilkan informasi mata kuliah, ID, dan kelas
        holder.txtNamaMk.text = "${mk.namaMk} (${mk.idMk})"
        holder.txtKelas.text = "Kelas: ${mk.kelas}"
    }

    override fun getItemCount(): Int = listMk.size
}
