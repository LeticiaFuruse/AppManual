package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var login: EditText
    lateinit var senha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        login = findViewById(R.id.login)
        senha = findViewById(R.id.senha)


    }


    fun btnEntrar(view: View) {
        val username = login.text.toString()
        val password = senha.text.toString()

        when {
            username == "user" && password == "123" -> {
                Toast.makeText(this, "Bem-vindo, usuário!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, pagPrincipal::class.java))
            }

            username == "admin" && password == "123" -> {
                Toast.makeText(this, "Bem-vindo, administrador!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, area_admin::class.java))
            }

            else -> {
                Toast.makeText(this, "Credenciais incorretas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verifica(username: String, password: String): Boolean {
        return username == "user" && password == "123"
    }
}
