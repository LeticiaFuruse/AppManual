package com.example.appmanual

// Singleton que armazena e gerencia a lista de produtos
object ProdutoRepository {

    // Lista interna para armazenar produtos
    private val produtos = mutableListOf<Produto>()

    // Função para adicionar um produto à lista
    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    // Função para obter a lista atual de produtos (imutável para fora)
    fun obterProdutos(): List<Produto> {
        return produtos.toList()
    }

    // Opcional: limpar lista (se precisar)
    fun limparProdutos() {
        produtos.clear()
    }
}
