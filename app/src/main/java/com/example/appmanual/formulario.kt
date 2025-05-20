package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)

        val radioSeca = findViewById<RadioButton>(R.id.radio_seca)
        val radioOleosa = findViewById<RadioButton>(R.id.radio_oleosa)
        val radioMista = findViewById<RadioButton>(R.id.radio_mista)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        val radios = listOf(radioSeca, radioOleosa, radioMista)

        val textoMap = mapOf(
            radioSeca to "Pele seca",
            radioOleosa to "Pele oleosa",
            radioMista to "Pele mista"
        )

        radios.forEach { radio ->
            radio.setOnClickListener {
                radios.forEach { it.isChecked = false }
                radio.isChecked = true
            }
        }

        btnEnviar.setOnClickListener {
            val selecionado = radios.find { it.isChecked }
            if (selecionado != null) {
                val textoSelecionado = textoMap[selecionado] ?: "Opção desconhecida"
                val intent = Intent(this, result_formulario::class.java)
                intent.putExtra("peleSelecionada", textoSelecionado)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Selecione uma opção", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
