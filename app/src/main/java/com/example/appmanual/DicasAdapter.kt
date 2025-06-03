package com.example.appmanual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DicasAdapter(
    private val dicas: List<Dica>,
    private val onSaibaMaisClick: (Dica) -> Unit
) : RecyclerView.Adapter<DicasAdapter.DicaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dica, parent, false)
        return DicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.bind(dica)
    }

    override fun getItemCount() = dicas.size

    inner class DicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitulo: TextView = itemView.findViewById(R.id.tvTituloDica)
        private val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricaoDica)
        private val btnSaibaMais: Button = itemView.findViewById(R.id.btnSaibaMais)

        fun bind(dica: Dica) {
            tvTitulo.text = dica.titulo
            tvDescricao.text = dica.descricao
            btnSaibaMais.text = dica.botaoTexto
            btnSaibaMais.setOnClickListener { onSaibaMaisClick(dica) }
        }
    }
} 