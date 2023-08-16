package com.fiap.jogodeadivinhacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bundle = intent.extras
        val resultText = findViewById<TextView>(R.id.resultText)
        val numberText = findViewById<TextView>(R.id.numberText)
        val returnButton = findViewById<Button>(R.id.returnButton)

        resultText.text = bundle!!.getString("res")
        numberText.text = bundle.getString("num")

        returnButton.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}