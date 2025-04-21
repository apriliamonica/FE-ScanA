package com.example.handscanattendance.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R

class MataKuliahAdapter(
    private var list: List<MataKuliah>,
    private val onClick: (MataKuliah) -> Unit
) : RecyclerView.Adapter<MataKuliahAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val namaText: TextView = view.findViewById(R.id.tv_nama_mk)
        private val infoText: TextView = view.findViewById(R.id.tv_info_mk)

        fun bind(mk: MataKuliah) {
            namaText.text = mk.nama
            infoText.text = "${mk.semester} - ${mk.tahunAkademik}"
            itemView.setOnClickListener { onClick(mk) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mata_kuliah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<MataKuliah>) {
        list = newList
        notifyDataSetChanged()
    }
}
