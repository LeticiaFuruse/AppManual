package com.example.appmanual

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Activity responsável por exibir o histórico de cuidados com a pele,
 * incluindo um resumo mensal e uma lista de registros.
 */
class HistoricoCuidadosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HistoricoAdapter
    private lateinit var tvRotinasCompletadas: TextView
    private lateinit var tvDiasConsecutivos: TextView
    private lateinit var btnRegistrarCuidado: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_cuidados)

        // Configuração da toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Histórico de Cuidados"

        // Inicialização das views
        initViews()
        
        // Configuração da RecyclerView
        setupRecyclerView()
        
        // Configuração dos listeners
        setupListeners()
        
        // Atualiza o resumo
        atualizarResumo()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerViewHistorico)
        tvRotinasCompletadas = findViewById(R.id.tvRotinasCompletadas)
        tvDiasConsecutivos = findViewById(R.id.tvDiasConsecutivos)
        btnRegistrarCuidado = findViewById(R.id.btnRegistrarCuidado)
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // Criando lista de registros mockada
        val registros = criarRegistrosMock()
        
        adapter = HistoricoAdapter(registros)
        recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        btnRegistrarCuidado.setOnClickListener {
            // Aqui você implementaria a lógica para registrar um novo cuidado
            // Por exemplo, abrir um dialog para selecionar o tipo de rotina
        }
    }

    private fun atualizarResumo() {
        // Aqui você implementaria a lógica para calcular o resumo real
        // Por enquanto, usando valores mockados
        tvRotinasCompletadas.text = "15"
        tvDiasConsecutivos.text = "7"
    }

    private fun criarRegistrosMock(): List<RegistroHistorico> {
        val registros = mutableListOf<RegistroHistorico>()
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
        val calendar = Calendar.getInstance()
        
        // Criando alguns registros de exemplo
        for (i in 0..10) {
            calendar.add(Calendar.HOUR, -8) // Subtrai 8 horas para cada registro
            val data = calendar.time
            
            registros.add(
                RegistroHistorico(
                    data = sdf.format(data).split(" ")[0],
                    horario = sdf.format(data).split(" ")[1],
                    tipoRotina = when (i % 3) {
                        0 -> "Rotina da Manhã"
                        1 -> "Rotina da Tarde"
                        else -> "Rotina da Noite"
                    },
                    concluido = true
                )
            )
        }
        
        return registros
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

// Modelo de dados para os registros do histórico
data class RegistroHistorico(
    val data: String,
    val horario: String,
    val tipoRotina: String,
    val concluido: Boolean
) 