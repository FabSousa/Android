package com.fiap.treino01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fiap.treino01.databinding.ResultViewBinding

class ResultActivity : AppCompatActivity() {
    private var binding: ResultViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_view)

        binding = ResultViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val i = intent
        val ageResult = i.getIntExtra("age", 0)

        binding?.resultText?.text = ageResult.toString()

        binding?.returnButton?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}