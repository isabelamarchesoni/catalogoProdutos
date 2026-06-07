package br.edu.fatecpg.appui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.appui.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        loadFragment("eletronicos")

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_eletronicos -> {
                    loadFragment("eletronicos")
                    showSnackbar("Eletrônicos")
                }
                R.id.nav_roupas -> {
                    loadFragment("roupas")
                    showSnackbar("Roupas")
                }
                R.id.nav_livros -> {
                    loadFragment("livros")
                    showSnackbar("Livros")
                }
                else -> {}
            }
            true
        }
    }

    private fun loadFragment(categoria: String) {
        val fragment = ListaFragment.newInstance(categoria)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }

    private fun showSnackbar(categoria: String) {
        Snackbar.make(
            findViewById(R.id.frameContainer),
            "Exibindo $categoria",
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(getColor(R.color.pink))
            .setTextColor(getColor(R.color.text_primary))
            .show()
    }
}