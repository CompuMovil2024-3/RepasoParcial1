package com.example.samplecmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplecmp.databinding.ActivityDisplayBinding

class DisplayActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero1 = intent.getStringExtra("numero1")
        val numero2 = intent.getStringExtra("numero2")
        val numero3 = intent.getStringExtra("numero3")

        val numerouno = numero1?.toIntOrNull()?:0
        val numerodos = numero2?.toIntOrNull()?:0
        val numerotres = numero3?.toIntOrNull()?:0

        val display = numerouno + numerodos + numerotres

        binding.suma.text = display.toString()







    }
}