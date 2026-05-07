package br.edu.fatecpg.appui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appui.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        loadFragment("eletronicos")

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_eletronicos -> loadFragment("eletronicos")
                R.id.nav_roupas -> loadFragment("roupas")
                R.id.nav_livros -> loadFragment("livros")
            }
            true
        }
    }

    private fun loadFragment(categoria: String) {
        val fragment = ListaFragment()
        val bundle = Bundle()
        bundle.putString("categoria", categoria)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}