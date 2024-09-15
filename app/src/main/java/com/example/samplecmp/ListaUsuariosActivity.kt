package com.example.samplecmp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.samplecmp.databinding.ActivityListaUsuariosBinding
import com.example.samplecmp.model.Usuario
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.IOException

class ListaUsuariosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaUsuariosBinding
    private var usuariosList: MutableList<Usuario> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadUsuarios()
        try {

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usuariosList)
            binding.main.adapter = adapter
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



   //Funcion loadUsuarios()
   private fun loadUsuarios() {
       try {
           val json_string = this.assets.open("usuarios.json").bufferedReader().use {
               it.readText()
           }
           val json = JSONObject(json_string)
           val usuariosArray = json.getJSONArray("usuarios")
           for (i in 0 until usuariosArray.length()) {
               val jsonObject = usuariosArray.getJSONObject(i)
               val nombre = jsonObject.getString("nombre")
               val apellido = jsonObject.getString("apellido")
               val correo = jsonObject.getString("correo")
               val contrasena = jsonObject.getString("contrasena")
               val telefono = jsonObject.getString("telefono")
               val user = Usuario(nombre, apellido, correo, contrasena, telefono)
               usuariosList.add(user)
           }
       } catch (e: IOException) {
           e.printStackTrace()
       } catch (e: Exception) {
           e.printStackTrace()
       }
   }



}