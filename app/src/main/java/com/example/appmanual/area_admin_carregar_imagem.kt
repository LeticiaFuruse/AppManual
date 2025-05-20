package com.example.appmanual

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class area_admin_carregar_imagem : AppCompatActivity() {
    lateinit var txtURL: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area_admin_carregar_imagem)

    }

    fun CarregarImagem(view: View){
        txtURL = findViewById(R.id.txtURL)
        var url = txtURL.text.toString()
        var imgDinamica = findViewById<ImageView>(R.id.imgDinamica)
        Glide.with(this).load(url).into(imgDinamica)
    }
}