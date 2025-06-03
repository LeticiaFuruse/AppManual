package com.example.appmanual

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity responsável por exibir a rotina diária de cuidados com a pele,
 * dividida em três períodos: manhã, tarde e noite.
 * Permite expandir/recolher os passos de cada período.
 */
class RotinaDiariaActivity : AppCompatActivity() {

    private lateinit var btnManha: Button
    private lateinit var btnTarde: Button
    private lateinit var btnNoite: Button
    private lateinit var layoutPassosManha: LinearLayout
    private lateinit var layoutPassosTarde: LinearLayout
    private lateinit var layoutPassosNoite: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotina_diaria)

        // Configuração da toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Rotina Diária"

        // Inicialização das views
        initViews()
        
        // Configuração dos listeners
        setupListeners()
    }

    private fun initViews() {
        btnManha = findViewById(R.id.btnManha)
        btnTarde = findViewById(R.id.btnTarde)
        btnNoite = findViewById(R.id.btnNoite)
        layoutPassosManha = findViewById(R.id.layoutPassosManha)
        layoutPassosTarde = findViewById(R.id.layoutPassosTarde)
        layoutPassosNoite = findViewById(R.id.layoutPassosNoite)
    }

    private fun setupListeners() {
        btnManha.setOnClickListener {
            toggleVisibility(layoutPassosManha, btnManha)
        }

        btnTarde.setOnClickListener {
            toggleVisibility(layoutPassosTarde, btnTarde)
        }

        btnNoite.setOnClickListener {
            toggleVisibility(layoutPassosNoite, btnNoite)
        }
    }

    private fun toggleVisibility(layout: LinearLayout, button: Button) {
        val isVisible = layout.visibility == View.VISIBLE
        layout.visibility = if (isVisible) View.GONE else View.VISIBLE
        button.text = if (isVisible) "Ver Passos" else "Ocultar Passos"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
} 