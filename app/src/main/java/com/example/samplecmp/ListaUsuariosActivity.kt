package com.example.samplecmp

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.samplecmp.databinding.ActivityListaUsuariosBinding
import com.example.samplecmp.model.Usuario
import org.json.JSONObject
import java.io.File
import java.io.IOException

class ListaUsuariosActivity : AppCompatActivity() {
    //1. Binding y lista de usuarios
    private lateinit var binding: ActivityListaUsuariosBinding
    private var usuariosList: MutableList<Usuario> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2. Inflar el layout
        binding = ActivityListaUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //3. Cargar usuarios
        loadUsuarios()

        //4. Crear un adaptador para la lista de usuarios
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usuariosList.map { "${it.nombre} ${it.apellido}" })
        binding.main.adapter = adapter

    }

    private fun loadUsuarios() {
        //a. Declara variable para almacenamiento externo -> Assets
        val externalStorageDir = getExternalFilesDir(null)
        //b. Crea un archivo JSON
        val file = File(externalStorageDir, "usuarios.json")
        //c. Lee el archivo JSON
        val jsonString = file.bufferedReader().use { it.readText() }
        //d. Convierte el JSON a un objeto
        val json = JSONObject(jsonString)
        //e. Obtiene el array de usuarios
        val usuariosArray = json.getJSONArray("usuarios")
        //f. Itera sobre el array de usuarios
        for (i in 0 until usuariosArray.length()) {
            //g. Obtiene el objeto JSON de cada usuario
            val jsonObject = usuariosArray.getJSONObject(i)
            val nombre = jsonObject.getString("nombre")
            val apellido = jsonObject.getString("apellido")
            val correo = jsonObject.getString("correo")
            val contrasena = jsonObject.getString("contrasena")
            val telefono = jsonObject.getString("telefono")
            //h. Crea un objeto Usuario y lo agrega a la lista
            val user = Usuario(nombre, apellido, correo, contrasena, telefono)
            usuariosList.add(user)
        }
    }
}