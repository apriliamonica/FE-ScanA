package com.example.handscanattendance.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R

class MataKuliahAdapter(
    private var list: List<MataKuliah>, // <- ubah jadi var
    private val onClick: (MataKuliah) -> Unit
) : RecyclerView.Adapter<MataKuliahAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaText: TextView = view.findViewById(R.id.tv_nama_mk)
        val infoText: TextView = view.findViewById(R.id.tv_info_mk)

        init {
            view.setOnClickListener {
                onClick(list[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mata_kuliah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mk = list[position]
        holder.namaText.text = mk.nama
        holder.infoText.text = "${mk.semester} - ${mk.tahunAkademik}"
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<MataKuliah>) {
        list = newList
        notifyDataSetChanged()
    }
}
