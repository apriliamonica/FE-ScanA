package com.example.handscanattendance.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.handscanattendance.R
import com.example.handscanattendance.ui.admin.MataKuliah

class MataKuliahAdapter(private var listMK: List<MataKuliah>) :
    RecyclerView.Adapter<MataKuliahAdapter.MKViewHolder>() {

    inner class MKViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtIdMK: TextView = view.findViewById(R.id.txt_id_mk)
        val txtNamaMK: TextView = view.findViewById(R.id.txt_nama_mk)
        val txtSemester: TextView = view.findViewById(R.id.txt_semester)
        val btnEdit: Button = view.findViewById(R.id.btn_edit)
        val btnDelete: Button = view.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MKViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mata_kuliah, parent, false)
        return MKViewHolder(view)
    }

    override fun onBindViewHolder(holder: MKViewHolder, position: Int) {
        val mk = listMK[position]
        holder.txtIdMK.text = mk.idMK
        holder.txtNamaMK.text = mk.namaMK
        holder.txtSemester.text = mk.semester

        holder.btnEdit.setOnClickListener {
            // TODO: implementasi edit mata kuliah
        }

        holder.btnDelete.setOnClickListener {
            // TODO: implementasi hapus mata kuliah
        }
    }

    override fun getItemCount(): Int = listMK.size

    fun updateList(newList: List<MataKuliah>) {
        listMK = newList
        notifyDataSetChanged()
    }
}
