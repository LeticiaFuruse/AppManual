package com.example.appmanual

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class result_formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_formulario)

        val resultadoTextView = findViewById<TextView>(R.id.textoResultado)
        val peleSelecionada = intent.getStringExtra("peleSelecionada")

        resultadoTextView.text = "Selecionado: $peleSelecionada"
    }
}