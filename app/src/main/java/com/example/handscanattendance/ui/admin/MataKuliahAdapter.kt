package com.example.handscanattendance.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handscanattendance.R
import com.example.handscanattendance.data.MataKuliah

class MataKuliahAdapter(private val list: List<MataKuliah>) :
    RecyclerView.Adapter<MataKuliahAdapter.MataKuliahViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MataKuliahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mata_kuliah, parent, false)
        return MataKuliahViewHolder(view)
    }

    override fun onBindViewHolder(holder: MataKuliahViewHolder, position: Int) {
        val mataKuliah = list[position]
        holder.txtIdMk.text = mataKuliah.idMk
        holder.txtNamaMk.text = mataKuliah.nama
        holder.txtSemester.text = mataKuliah.semester

        holder.btnEdit.setOnClickListener {
            // Nanti tambahkan fitur edit di sini
        }

        holder.btnDelete.setOnClickListener {
            // Nanti tambahkan fitur delete di sini
        }
    }

    override fun getItemCount(): Int = list.size

    class MataKuliahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtIdMk: TextView = itemView.findViewById(R.id.txt_id_mk)
        val txtNamaMk: TextView = itemView.findViewById(R.id.txt_nama_mk)
        val txtSemester: TextView = itemView.findViewById(R.id.txt_semester)
        val btnEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }
}
