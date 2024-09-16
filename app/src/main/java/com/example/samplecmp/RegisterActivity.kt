package com.example.samplecmp

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samplecmp.databinding.ActivityRegisterBinding
import com.example.samplecmp.model.Usuario
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar ViewBinding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mover el archivo usuarios.json a almacenamiento externo si no existe
        moveJsonFileToExternalStorage()

        // Configurar el botón de registro
        binding.crearcuenta.setOnClickListener {
            val nombre = binding.name.text.toString()
            val apellido = binding.apellido.text.toString()
            val correo = binding.email.text.toString()
            val contrasena = binding.contrasena.text.toString()
            val telefono = binding.telefono.text.toString()

            // Validar campos
            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear un nuevo objeto Usuario
            val nuevoUsuario = Usuario(
                nombre = nombre,
                apellido = apellido,
                correo = correo,
                contrasena = contrasena,
                telefono = telefono
            )

            // Agregar el usuario al archivo JSON
            try {
                addUsuarioToJson(nuevoUsuario)
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun moveJsonFileToExternalStorage() {
        val externalStorageDir = getExternalFilesDir(null)
        val file = File(externalStorageDir, "usuarios.json")
        if (!file.exists()) {
            assets.open("usuarios.json").use { inputStream ->
                FileOutputStream(file).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        }
    }

    private fun addUsuarioToJson(usuario: Usuario) {
        val externalStorageDir = getExternalFilesDir(null)
        val file = File(externalStorageDir, "usuarios.json")
        val jsonString = file.bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonString)
        val usuariosJsonArray = jsonObject.getJSONArray("usuarios")

        // Crear el nuevo JSONObject con los datos del usuario
        val newUserJsonObject = JSONObject().apply {
            put("nombre", usuario.nombre)
            put("apellido", usuario.apellido)
            put("correo", usuario.correo)
            put("contrasena", usuario.contrasena)
            put("telefono", usuario.telefono)
        }

        // Añadir el nuevo usuario al JSONArray
        usuariosJsonArray.put(newUserJsonObject)

        // Escribir de nuevo el JSONArray en el archivo
        val updatedJsonObject = JSONObject().apply {
            put("usuarios", usuariosJsonArray)
        }
        FileOutputStream(file).use { output ->
            output.write(updatedJsonObject.toString().toByteArray())
        }
    }
}