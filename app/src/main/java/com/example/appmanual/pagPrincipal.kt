package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pagPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pag_principal)

        //chamando minha toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    //abrir o menu de botões
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun btnComecar(view: View){
        var intent = Intent(this,formulario()::class.java)
        startActivity(intent)
    }
}