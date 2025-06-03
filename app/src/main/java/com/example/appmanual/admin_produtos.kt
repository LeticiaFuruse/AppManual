package com.example.appmanual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class admin_produtos : AppCompatActivity() {

    private lateinit var btnNomeProd: EditText
    private lateinit var btnPrecoProd: EditText
    private lateinit var btnDescricaoProd: EditText
    private lateinit var btnLinkProd: EditText
    private lateinit var btnAdicionar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_produtos)

        btnNomeProd = findViewById(R.id.btnNomeProd)
        btnPrecoProd = findViewById(R.id.btnPrecoProd)
        btnDescricaoProd = findViewById(R.id.btnDescricaoProd)
        btnLinkProd = findViewById(R.id.btnLinkProd)
        btnAdicionar = findViewById(R.id.btnAdicionar)

        btnAdicionar.setOnClickListener {
            val nomeProduto = btnNomeProd.text.toString()
            val precoProduto = btnPrecoProd.text.toString()
            val descricaoProduto = btnDescricaoProd.text.toString()
            val linkProduto = btnLinkProd.text.toString()

            if (nomeProduto.isNotEmpty()) {
                // Cria produto e adiciona na lista global
                val produto = Produto(nomeProduto, precoProduto, descricaoProduto, linkProduto)
                // usa o metodo singletown para adicionar


                // Limpa os campos
                btnNomeProd.text.clear()
                btnPrecoProd.text.clear()
                btnDescricaoProd.text.clear()
                btnLinkProd.text.clear()

                // tela admin listar produto
                val intent = Intent(this, admin_listar_produto::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Digite um nome de produto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
