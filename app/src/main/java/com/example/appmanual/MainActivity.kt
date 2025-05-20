package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
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

        if (verifica(username, password)) {
            Toast.makeText(this, "Bem-vindo", Toast.LENGTH_LONG).show()
            val intent = Intent(this, pagPrincipal::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Credenciais incorretas", Toast.LENGTH_LONG).show()
        }
    }

    private fun verifica(username: String, password: String): Boolean {
        return username == "admin" && password == "123"
    }
}
