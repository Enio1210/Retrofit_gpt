package com.example.retrofit_gpt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class VersiculoAdapter(private var versiculos: List<Bible_Model>) :
    RecyclerView.Adapter<VersiculoAdapter.VersiculoViewHolder>() {

    inner class VersiculoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoView: TextView = itemView.findViewById(R.id.textoView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersiculoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return VersiculoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VersiculoViewHolder, position: Int) {
        val versiculo = versiculos[position]
        holder.textoView.text = "${versiculo.id} ${versiculo.bibleId}:${versiculo.chapterId}"
    }

    override fun getItemCount(): Int {
        return versiculos.size
    }

    fun atualizarLista(novaLista: List<Bible_Model>) {
        versiculos = novaLista
        notifyDataSetChanged()
    }
}