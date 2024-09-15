package com.example.samplecmp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplecmp.databinding.ActivityRegisterBinding
import com.example.samplecmp.databinding.ActivityTeAmoBinding
import com.example.samplecmp.model.Usuario
import com.google.gson.Gson
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var usuariosCargar: MutableList<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.crearcuenta.setOnClickListener{
            crearUsuario()
        }

        binding.yatengocuenta.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }
    }

    private fun crearUsuario() {
        val intent = Intent(this, ListaUsuariosActivity::class.java)
        intent.putExtra("usuarios", Gson().toJson(usuariosCargar))
        startActivity(intent)
    }



}