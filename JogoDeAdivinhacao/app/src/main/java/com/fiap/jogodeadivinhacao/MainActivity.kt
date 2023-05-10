package com.fiap.jogodeadivinhacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ResultActivity::class.java)

        val input = findViewById<EditText>(R.id.input)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val hintText = findViewById<TextView>(R.id.hintText)
        val chancesText = findViewById<TextView>(R.id.chancesText)

        val number = Random.nextInt(1, 100)
        var chances = 3;

        submitButton.setOnClickListener() {
            var bundle = Bundle()
            bundle.putString("num", number.toString())

            if (chances > 0){
                if(input.text.toString().toInt() > number)
                    hintText.text = "Maior"
                else
                    hintText.text = "Menor"
                chances --
                chancesText.text = "Tentativas restantes: " + chances

                if(input.text.toString().toInt() == number){
                    bundle.putString("res", "Acertou")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }else{
                bundle.putString("res", "Errou")
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }




    }
}