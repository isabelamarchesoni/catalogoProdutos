package br.edu.fatecpg.appui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appui.R
import br.edu.fatecpg.appui.model.Produto

class ProdutoAdapter(private val lista: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.txtNome)
        val preco = view.findViewById<TextView>(R.id.txtPreco)
        val imagem = view.findViewById<ImageView>(R.id.imgProduto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = lista[position]
        holder.nome.text = produto.nome
        holder.preco.text = produto.preco
        holder.imagem.setImageResource(produto.imagem)
    }

    override fun getItemCount() = lista.size
}