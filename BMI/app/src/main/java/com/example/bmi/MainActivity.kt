package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateBMI(view: View){
        val weightObj = findViewById<EditText>(R.id.weight)
        val heightObj = findViewById<EditText>(R.id.height)
        val resultObj = findViewById<TextView>(R.id.result)
        val h:Float = heightObj.text.toString().toFloat() / 100
        val w:Float = weightObj.text.toString().toFloat()
        val bmi = w / (h * h);

        resultObj.text = getBMITest(bmi)
    }

    fun getBMITest(bmi: Float): String{
        if(bmi <= 18.5){
            return "Magro"
        }else if(bmi <= 24.9){
            return "Normal"
        }else if(bmi <= 29.9){
            return "Sobrepeso"
        }else if(bmi <= 34.9){
            return "Obesidade 1"
        }else if(bmi <= 39.9){
            return  "Obesidade 2"
        }else{
            return "Obesidade 3"
        }
    }

}