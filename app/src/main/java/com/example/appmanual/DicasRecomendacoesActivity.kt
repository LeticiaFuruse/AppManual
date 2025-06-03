package com.example.appmanual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Activity responsável por exibir dicas e recomendações de cuidados com a pele
 * usando uma RecyclerView com cards informativos.
 */
class DicasRecomendacoesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DicasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dicas_recomendacoes)

        // Configuração da toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dicas e Recomendações"

        // Inicialização da RecyclerView
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewDicas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // Criando lista de dicas mockada
        val dicas = listOf(
            Dica(
                "Hidratação é Fundamental",
                "Mantenha sua pele sempre hidratada bebendo bastante água e usando hidratantes adequados para seu tipo de pele.",
                "Saiba mais sobre hidratação"
            ),
            Dica(
                "Proteção Solar Diária",
                "Use protetor solar todos os dias, mesmo em dias nublados ou quando ficar em ambientes fechados.",
                "Aprenda sobre proteção solar"
            ),
            Dica(
                "Limpeza Adequada",
                "Lave o rosto duas vezes ao dia com produtos específicos para seu tipo de pele.",
                "Técnicas de limpeza facial"
            ),
            Dica(
                "Alimentação Saudável",
                "Uma dieta equilibrada rica em vitaminas e minerais contribui para uma pele mais saudável.",
                "Alimentos para pele bonita"
            ),
            Dica(
                "Sono Reparador",
                "Dormir bem é essencial para a renovação celular e saúde da pele.",
                "Importância do sono"
            )
        )

        adapter = DicasAdapter(dicas) { dica ->
            // Aqui você pode implementar a ação do botão "Saiba Mais"
            // Por exemplo, abrir uma nova Activity com mais detalhes
        }
        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

// Modelo de dados para as dicas
data class Dica(
    val titulo: String,
    val descricao: String,
    val botaoTexto: String
) 