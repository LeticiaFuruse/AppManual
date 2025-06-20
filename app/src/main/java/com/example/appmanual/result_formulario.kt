package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class result_formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_formulario)

        //chamando minha toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        val resultadoTextView = findViewById<TextView>(R.id.textoResultado)
        val peleSelecionada = intent.getStringExtra("peleSelecionada")

        resultadoTextView.text = "Selecionado: $peleSelecionada"
    }

    //abrir o menu de botões
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Função que captura o clique nos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnQuemSomos -> {
                val intent = Intent(this, pag_quem_somos::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun btnComprar(view: View){
        var intent = Intent(this,itemHistorico()::class.java)
        startActivity(intent)
    }
}