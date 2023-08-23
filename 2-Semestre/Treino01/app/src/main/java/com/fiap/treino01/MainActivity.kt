package com.fiap.treino01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fiap.treino01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.validateButton?.setOnClickListener {
            val age: Int = Integer.parseInt(binding?.input?.text.toString())

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("age", age)
            startActivity(intent)
        }
    }
}