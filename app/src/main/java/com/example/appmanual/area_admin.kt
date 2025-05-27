package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class area_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_area_admin)

        val telaUpload: Button = findViewById(R.id.btnUploadImagem)
        telaUpload.setOnClickListener {
            var intent = Intent(this, area_admin_carregar_imagem::class.java)
            startActivity(intent)
        }

        val telaAdminUsuario: Button = findViewById(R.id.btnUsuarios)
        telaAdminUsuario.setOnClickListener{
            var intent = Intent(this, admin_usuarios::class.java)
            startActivity(intent)
        }
        val telaAdminProdutos: Button = findViewById(R.id.btnProdutos)
        telaAdminProdutos.setOnClickListener{
            var intent = Intent(this, admin_produtos::class.java)
            startActivity(intent)
        }
    }
}