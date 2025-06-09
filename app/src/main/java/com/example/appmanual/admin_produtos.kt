package com.example.appmanual

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class admin_produtos : AppCompatActivity() {

    // Declaração dos elementos da interface
    private lateinit var btnNomeProd: EditText
    private lateinit var btnPrecoProd: EditText
    private lateinit var btnDescricaoProd: EditText
    private lateinit var btnLinkProd: EditText
    private lateinit var btnAdicionar: Button
    private lateinit var layoutLista: LinearLayout // Para exibir os produtos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_produtos)

        // Referência dos elementos da tela
        btnNomeProd = findViewById(R.id.btnNomeProd)
        btnPrecoProd = findViewById(R.id.btnPrecoProd)
        btnDescricaoProd = findViewById(R.id.btnDescricaoProd)
        btnLinkProd = findViewById(R.id.btnLinkProd)
        btnAdicionar = findViewById(R.id.btnAdicionar)
        layoutLista = findViewById(R.id.layoutLista)

        // Ação do botão "Adicionar Produto"
        btnAdicionar.setOnClickListener {
            val nome = btnNomeProd.text.toString()
            val preco = btnPrecoProd.text.toString()
            val descricao = btnDescricaoProd.text.toString()
            val link = btnLinkProd.text.toString()

            if (nome.isNotEmpty()) {
                adicionarProdutoNaLista(nome, preco, descricao, link)

                // Limpar campos após adicionar
                btnNomeProd.text.clear()
                btnPrecoProd.text.clear()
                btnDescricaoProd.text.clear()
                btnLinkProd.text.clear()
            } else {
                Toast.makeText(this, "Digite um nome de produto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Função que adiciona dinamicamente um bloco com os dados do produto
    private fun adicionarProdutoNaLista(nome: String, preco: String, descricao: String, link: String) {
        val itemLayout = LinearLayout(this)
        itemLayout.orientation = LinearLayout.VERTICAL
        itemLayout.setPadding(16, 16, 16, 16)
        itemLayout.setBackgroundColor(0xFFE0E0E0.toInt())

        val nomeView = TextView(this)
        nomeView.text = "Nome: $nome"
        nomeView.textSize = 18f

        val precoView = TextView(this)
        precoView.text = "Preço: $preco"
        precoView.textSize = 16f

        val descricaoView = TextView(this)
        descricaoView.text = "Descrição: $descricao"
        descricaoView.textSize = 16f

        val linkView = TextView(this)
        linkView.text = "Link: $link"
        linkView.textSize = 16f

        val linha = TextView(this)
        linha.text = "---------------------------"

        // Adicionando os TextViews ao item
        itemLayout.addView(nomeView)
        itemLayout.addView(precoView)
        itemLayout.addView(descricaoView)
        itemLayout.addView(linkView)
        itemLayout.addView(linha)

        layoutLista.addView(itemLayout)
    }
}
