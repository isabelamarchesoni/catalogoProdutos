package br.edu.fatecpg.appui.model

data class Produto(
    val nome: String,
    val preco: String,
    val imagem: Int,
    val fundoTransparente: Boolean = false,
    val subtitulo: String? = null  // ← adicionar isso
)