package com.example.samplecmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplecmp.databinding.ActivityTeAmoBinding

class TeAmoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeAmoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeAmoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}