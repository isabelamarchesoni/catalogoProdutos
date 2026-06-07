package br.edu.fatecpg.appui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appui.R
import br.edu.fatecpg.appui.adapter.ProdutoAdapter
import br.edu.fatecpg.appui.model.Produto

class ListaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance(categoria: String): ListaFragment {
            val fragment = ListaFragment()
            val bundle = Bundle()
            bundle.putString("categoria", categoria)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        recyclerView = view.findViewById(R.id.recyclerProdutos)

        val categoria = arguments?.getString("categoria") ?: "eletronicos"

        val lista = when (categoria) {
            "eletronicos" -> listOf(
                Produto("iPhone 13 Rosa", "R$ 3.299,00", R.drawable.img_celular),
                Produto("AirPods 4", "R$ 1.249,00", R.drawable.img_fone),
                Produto("Monitor", "R$ 1.200,00", R.drawable.img_monitor),
                Produto("MacBook Air Estelar", "R$ 7.499,00", R.drawable.img_notebook)
            )
            "roupas" -> listOf(
                Produto("Regata Floral", "R$ 60,00", R.drawable.img_blusa),
                Produto("Regata Rosa Canelada", "R$ 70,00", R.drawable.img_blusa_rosa),
                Produto("Jaqueta Adidas", "R$ 150,00", R.drawable.img_casaco)
            )
            else -> listOf(
                Produto("A Razão do Amor", "R$ 80,00", R.drawable.img_livro_um, false, "Ali Hazelwood"),
                Produto("Para Todos os Garotos que Já Amei", "R$ 75,00", R.drawable.img_livro_dois, false, "Jenny Han"),
                Produto("Orgulho e Preconceito", "R$ 90,00", R.drawable.img_livro_tres, false, "Jane Austen")
            )
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProdutoAdapter(lista)

        return view
    }
}