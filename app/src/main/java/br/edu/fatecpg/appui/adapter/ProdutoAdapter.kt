package br.edu.fatecpg.appui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appui.R
import br.edu.fatecpg.appui.model.Produto

class ProdutoAdapter(private val lista: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome        = view.findViewById<TextView>(R.id.txtNome)
        val subtitulo   = view.findViewById<TextView>(R.id.txtSubtitulo)
        val preco       = view.findViewById<TextView>(R.id.txtPreco)
        val imagem      = view.findViewById<ImageView>(R.id.imgProduto)
        val frameLayout = view.findViewById<FrameLayout>(R.id.frameImagem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = lista[position]
        val ctx = holder.itemView.context

        holder.nome.text = produto.nome
        holder.preco.text = produto.preco

        if (!produto.subtitulo.isNullOrBlank()) {
            holder.subtitulo.text = produto.subtitulo
            holder.subtitulo.visibility = View.VISIBLE
        } else {
            holder.subtitulo.visibility = View.GONE
        }

        holder.imagem.setImageResource(produto.imagem)
        holder.frameLayout.setBackgroundColor(
            ContextCompat.getColor(ctx, R.color.frame_imagem_bg)
        )

        if (produto.fundoTransparente) {
            holder.imagem.scaleType = ImageView.ScaleType.FIT_CENTER
            holder.imagem.adjustViewBounds = true
            holder.imagem.setPadding(32, 20, 32, 20)
        } else {
            holder.imagem.scaleType = ImageView.ScaleType.CENTER_INSIDE
            holder.imagem.adjustViewBounds = false
            holder.imagem.setPadding(24, 24, 24, 24)
        }
    }

    override fun getItemCount() = lista.size
}