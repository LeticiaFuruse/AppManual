package com.example.appmanual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoricoAdapter(
    private val registros: List<RegistroHistorico>
) : RecyclerView.Adapter<HistoricoAdapter.HistoricoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_historico, parent, false)
        return HistoricoViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoricoViewHolder, position: Int) {
        val registro = registros[position]
        holder.bind(registro)
    }

    override fun getItemCount() = registros.size

    inner class HistoricoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvData: TextView = itemView.findViewById(R.id.tvData)
        private val tvHorario: TextView = itemView.findViewById(R.id.tvHorario)
        private val tvTipoRotina: TextView = itemView.findViewById(R.id.tvTipoRotina)
        private val ivStatus: ImageView = itemView.findViewById(R.id.ivStatus)

        fun bind(registro: RegistroHistorico) {
            tvData.text = registro.data
            tvHorario.text = registro.horario
            tvTipoRotina.text = registro.tipoRotina
            
            // Configura o ícone de status

        }
    }
} 