package com.example.checkpoint02

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.checkpoint02.databinding.ActivityResultBinding

class ResultActivity  : AppCompatActivity() {
    private  var binding: ActivityResultBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.root?.setBackgroundColor(Color.parseColor(intent.getStringExtra("color")))

        binding?.backButton?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}