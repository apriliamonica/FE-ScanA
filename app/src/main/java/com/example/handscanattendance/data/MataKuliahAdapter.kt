package com.example.handscanattendance.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R


class MataKuliahAdapter(
    private val mataKuliahList: List<MataKuliah>,
    private val onItemClick: (MataKuliah) -> Unit
) : RecyclerView.Adapter<MataKuliahAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val namaMkTextView: TextView = itemView.findViewById(R.id.tv_nama_mk)
        private val infoMkTextView: TextView = itemView.findViewById(R.id.tv_info_mk)

        fun bind(mataKuliah: MataKuliah) {
            namaMkTextView.text = mataKuliah.nama
            infoMkTextView.text = "Semester ${mataKuliah.semester} - ${mataKuliah.tahunAkademik}"

            itemView.setOnClickListener {
                onItemClick(mataKuliah)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mata_kuliah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mataKuliahList[position])
    }

    override fun getItemCount(): Int = mataKuliahList.size
}
