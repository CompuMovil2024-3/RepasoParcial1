package com.example.samplecmp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplecmp.databinding.ActivityNumerosBinding

class NumerosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNumerosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumerosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviar.setOnClickListener{
            val intent = Intent(this, DisplayActivity::class.java)
            var numero1 = binding.numero1.text.toString()
            var numero2 = binding.numero2.text.toString()
            var numero3= binding.numero3.text.toString()
            intent.putExtra("numero1", numero1)
            intent.putExtra("numero2", numero2)
            intent.putExtra("numero3", numero3)
            startActivity(intent)
        }
    }
}