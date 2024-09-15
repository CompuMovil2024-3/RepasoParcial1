package com.example.samplecmp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplecmp.databinding.ActivityRegisterBinding
import com.example.samplecmp.databinding.ActivityTeAmoBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.crearcuenta.setOnClickListener{
            startActivity(Intent(this, TeAmoActivity::class.java))
        }

        binding.yatengocuenta.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}