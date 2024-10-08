package com.example.samplecmp

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplecmp.databinding.ActivityMainBinding
import com.example.samplecmp.RegisterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iniciarSesion.setOnClickListener {
            startActivity(Intent(this, NumerosActivity::class.java))
        }

        binding.crearCuenta.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.cargarUsuarios.setOnClickListener{
            startActivity(Intent(this, ListaUsuariosActivity::class.java))
        }
    }
}