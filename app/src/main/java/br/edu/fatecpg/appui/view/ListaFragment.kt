package br.edu.fatecpg.appui.view

import br.edu.fatecpg.appui.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appui.adapter.ProdutoAdapter
import br.edu.fatecpg.appui.model.Produto
import androidx.fragment.app.Fragment

class ListaFragment : Fragment() {

        private lateinit var recyclerView: RecyclerView

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val view = inflater.inflate(R.layout.fragment_lista, container, false)
            recyclerView = view.findViewById(R.id.recyclerProdutos)

            val categoria = arguments?.getString("categoria")

            val lista = when (categoria) {
                "eletronicos" -> listOf(
                    Produto("Celular", "R$ 1500", android.R.drawable.ic_menu_gallery),
                    Produto("Notebook", "R$ 3500", android.R.drawable.ic_menu_gallery)
                )
                "roupas" -> listOf(
                    Produto("Camiseta", "R$ 50", android.R.drawable.ic_menu_gallery),
                    Produto("Calça", "R$ 120", android.R.drawable.ic_menu_gallery)
                )
                else -> listOf(
                    Produto("Livro Kotlin", "R$ 80", android.R.drawable.ic_menu_gallery),
                    Produto("Livro Android", "R$ 90", android.R.drawable.ic_menu_agenda)
                )
            }

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = ProdutoAdapter(lista)

            return view
    }
}