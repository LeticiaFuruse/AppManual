package com.example.appmanual

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class admin_produtos : AppCompatActivity() {

    // Declarando os elementos da interface
    private lateinit var btnNomeProd: EditText
    private lateinit var btnPrecoProd: EditText
    private lateinit var btnDescricaoProd: EditText
    private lateinit var btnLinkProd: EditText

    private lateinit var btnAdicionar: Button
    private lateinit var layoutLista: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_produtos)

        //Referenciando os elementos da tela
        btnNomeProd = findViewById(R.id.btnNomeProd)
        btnPrecoProd = findViewById(R.id.btnPrecoProd)
        btnDescricaoProd = findViewById(R.id.btnDescricaoProd)
        btnLinkProd = findViewById(R.id.btnLinkProd)

        btnAdicionar = findViewById(R.id.btnAdicionar)
        layoutLista = findViewById(R.id.layoutLista)

        //Ação do botão de adicionar produto
        btnAdicionar.setOnClickListener {
            val nomeProduto = btnNomeProd.text.toString()
            val precoProduto = btnPrecoProd.text.toString()
            val descricaoProduto = btnDescricaoProd.text.toString()
            val linkProduto = btnLinkProd.text.toString()

            if (nomeProduto.isNotEmpty()) {
                adicionarProdutoNaLista(nomeProduto, precoProduto, descricaoProduto, linkProduto) // Função para adicionar na lista
                btnNomeProd.text.clear() //Limpa o campo após adicionar
                btnPrecoProd.text.clear()
                btnDescricaoProd.text.clear()
                btnLinkProd.text.clear()
            } else {
                //Exibe um aviso se o campo estiver vazio
                Toast.makeText(this, "Digite um nome de produto", Toast.LENGTH_SHORT).show()
            }
        }

    }


    //Função que cria um TextView dinamicamente e adiciona na lista
    private fun adicionarProdutoNaLista(nome: String, preco: String, descricao: String, link: String) {


        //layout vertical para organizar as informações do produto
        val itemLayout = LinearLayout(this)
        itemLayout.orientation = LinearLayout.VERTICAL
        itemLayout.setPadding(16, 16, 16, 16)

        // Simula um "quadrado" com fundo cinza claro
        itemLayout.setBackgroundColor(0xFFE0E0E0.toInt()) // Cor de fundo


        //Cria TextViews para cada informação
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

        //Adiciona os TextViews dentro do layout do item
        itemLayout.addView(nomeView)
        itemLayout.addView(precoView)
        itemLayout.addView(descricaoView)
        itemLayout.addView(linkView)

        //Cria uma linha separadora para ficar mais organizado
        val linha = TextView(this)
        linha.text = "---------------------------"
        itemLayout.addView(linha)

        //Adiciona o item completo dentro do LinearLayout principal
        layoutLista.addView(itemLayout)
    }
}