package com.example.checkpoint02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checkpoint02.databinding.ActivityMainBinding

import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.graphics.ColorUtils
import com.madrapps.pikolo.ColorPicker
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener
import java.util.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityMainBinding? = null

    private lateinit var colorPicker: ColorPicker
    private lateinit var imageView: ImageView
    private lateinit var randomColorButton: Button
    private val random = Random()

    var colorSelected = "#000000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        imageView = binding?.imageView!!
        colorPicker = binding?.colorPicker!!
        colorPicker.setColorSelectionListener(object : SimpleColorSelectionListener() {
            override fun onColorSelected(color: Int) {
                colorSelected = "#${Integer.toHexString(color)}"

                Log.d("colorSelected", colorSelected)
                imageView.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
            }
        })

        initializeColorButtons()

        randomColorButton = binding?.randomColorButton!!
        randomColorButton.setOnClickListener(this)

        var colorOption = enableRGB()
        binding?.colorOptions?.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == binding?.colorRGBOption?.id) {
                colorOption = enableRGB()
            } else {
                colorOption = enablePicker()
            }
        }


        binding?.setButton?.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            if(colorOption == "RGB"){
                intent.putExtra("color", getColor())
            }else{
                intent.putExtra("color", colorSelected)
            }
            startActivity(intent)
        }
    }

    private fun initializeColorButtons() {
        binding?.imageButton1?.setOnClickListener(this)
        binding?.imageButton2?.setOnClickListener(this)
        binding?.imageButton3?.setOnClickListener(this)
        binding?.imageButton4?.setOnClickListener(this)
        binding?.imageButton5?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == binding?.randomColorButton?.id!!) {
            val color = ColorUtils.HSLToColor(floatArrayOf(random.nextInt(360).toFloat(), random.nextFloat(), random.nextFloat()))
            val hexColor = String.format("#%06X", 0xFFFFFF and color)
            randomColorButton.text = hexColor
            randomColorButton.setBackgroundColor(color)
            imageView.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
            colorPicker.setColor(color)
            colorSelected = "#${Integer.toHexString(color)}"
        }
        if (v is ImageButton) {
            val color = (v.drawable as ColorDrawable).color
            imageView.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
            colorPicker.setColor(color)
            colorSelected = "#${Integer.toHexString(color)}"
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

    private fun enableRGB(): String {
        binding?.iconRed?.visibility = View.VISIBLE
        binding?.inputRed?.visibility = View.VISIBLE
        binding?.iconGreen?.visibility = View.VISIBLE
        binding?.inputGreen?.visibility = View.VISIBLE
        binding?.iconBlue?.visibility = View.VISIBLE
        binding?.inputBlue?.visibility = View.VISIBLE

        binding?.colorPicker?.visibility = View.GONE
        binding?.imageView?.visibility = View.GONE
        binding?.randomColorButton?.visibility = View.GONE
        binding?.imageButton1?.visibility = View.GONE
        binding?.imageButton2?.visibility = View.GONE
        binding?.imageButton3?.visibility = View.GONE
        binding?.imageButton4?.visibility = View.GONE
        binding?.imageButton5?.visibility = View.GONE

        return "RGB"
    }

    private fun enablePicker(): String {
        binding?.colorPicker?.visibility = View.VISIBLE
        binding?.imageView?.visibility = View.VISIBLE
        binding?.randomColorButton?.visibility = View.VISIBLE
        binding?.imageButton1?.visibility = View.VISIBLE
        binding?.imageButton2?.visibility = View.VISIBLE
        binding?.imageButton3?.visibility = View.VISIBLE
        binding?.imageButton4?.visibility = View.VISIBLE
        binding?.imageButton5?.visibility = View.VISIBLE

        binding?.iconRed?.visibility = View.GONE
        binding?.inputRed?.visibility = View.GONE
        binding?.iconGreen?.visibility = View.GONE
        binding?.inputGreen?.visibility = View.GONE
        binding?.iconBlue?.visibility = View.GONE
        binding?.inputBlue?.visibility = View.GONE

        return "ColorPicker"
    }
}