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
            startActivity(Intent(this, TeAmoActivity::class.java))

        }

        binding.yatengocuenta.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }
    }

    private fun crearUsuario() {
        val intent = Intent(this, TeAmoActivity::class.java)
        usuariosCargar= loadUsuarios()
        intent.putExtra("usuarios", Gson().toJson(usuariosCargar))
        startActivity(intent)
    }


    fun loadUsuarios(): MutableList<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        val json_string = this.assets.open("paises.json").bufferedReader().use{
            it.readText()
        }
        var json = JSONObject(json_string);
        var usuariosArray = json.getJSONArray("usuarios");
        for (i in 0..usuariosArray.length()-1) {
            val jsonObject = usuariosArray.getJSONObject(i)
            val nombre = jsonObject.getString("nombre")
            val apellido = jsonObject.getString("apellido")
            val correo = jsonObject.getString("correo")
            val contrasena = jsonObject.getString("contrasena")
            val telefono = jsonObject.getString("telefono")
            val user = Usuario(nombre, apellido, correo, contrasena, telefono)
            usuarios.add(user)
        }
        return usuarios
    }
}