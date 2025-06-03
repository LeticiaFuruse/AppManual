package com.example.appmanual

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class admin_listar_produto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_admin_listar_produto)

        val arrayAdapter: ArrayAdapter<*>
        val produtos = arrayOf(
            "Sabonete ant-Acne",
            "Hidratante",
            "Esfoliante"
        )

        var lista = findViewById<ListView>(R.id.listView)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,produtos)
        lista.adapter = arrayAdapter

    }
}