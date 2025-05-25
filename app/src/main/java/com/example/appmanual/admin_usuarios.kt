package com.example.appmanual

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class admin_usuarios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_usuarios)


    }

    fun btnDelete (view:View){
        AlertDialog.Builder(this)
            .setTitle("Item excluido!")
            .setMessage("você excluiu esse usuario do banco")
            .setPositiveButton("OK"){
                    variavel, numeroOpcao ->
            }
            .create()
            .show()

    }


}