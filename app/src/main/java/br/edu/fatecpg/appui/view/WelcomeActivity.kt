package br.edu.fatecpg.appui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import br.edu.fatecpg.appui.view.MainActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        findViewById<MaterialButton>(R.id.btnEntrar).setOnClickListener {
            irParaMain()
        }
    }

    private fun irParaMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}