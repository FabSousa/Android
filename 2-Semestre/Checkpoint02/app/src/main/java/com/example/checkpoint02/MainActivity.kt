package com.example.checkpoint02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.checkpoint02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        enableRGB()
        binding?.colorOptions?.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == binding?.colorRGB?.id) {
                enableRGB()
            } else {
                enablePicker()
            }
        }


        binding?.setButton?.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("color", getColor())
            startActivity(intent)
        }
    }

    private fun getColor(): String {
        var inputRed = binding?.inputRed?.text.toString()
        var inputGreen = binding?.inputGreen?.text.toString()
        var inputBlue = binding?.inputBlue?.text.toString()

        if (inputRed.isEmpty()){
            inputRed = "00"
        }
        if (inputGreen.isEmpty()){
            inputGreen = "00"
        }
        if (inputBlue.isEmpty()){
            inputBlue = "00"
        }

        return "#$inputRed$inputGreen$inputBlue"
    }

    private fun enableRGB(){
        binding?.iconRed?.visibility = View.VISIBLE
        binding?.inputRed?.visibility = View.VISIBLE
        binding?.iconGreen?.visibility = View.VISIBLE
        binding?.inputGreen?.visibility = View.VISIBLE
        binding?.iconBlue?.visibility = View.VISIBLE
        binding?.inputBlue?.visibility = View.VISIBLE


    }

    private fun enablePicker(){


        binding?.iconRed?.visibility = View.GONE
        binding?.inputRed?.visibility = View.GONE
        binding?.iconGreen?.visibility = View.GONE
        binding?.inputGreen?.visibility = View.GONE
        binding?.iconBlue?.visibility = View.GONE
        binding?.inputBlue?.visibility = View.GONE
    }
}