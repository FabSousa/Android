package com.example.checkpoint02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.checkpoint02.databinding.ActivityMainBinding
import yuku.ambilwarna.AmbilWarnaDialog;

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var defaultColor = 8421504
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var option = enableRGB()
        binding?.colorOptions?.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == binding?.colorRGB?.id) {
                option = enableRGB()
            } else {
                option = enablePicker()
            }
        }

        binding?.colorPickerSelector?.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    openColorPickerDialogue()
                }
            })


        binding?.setButton?.setOnClickListener {
            var color : String;

            if(option == "RGB"){
                color = getColorRGB()
            }else{
                color = "#${Integer.toHexString(defaultColor)}"
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("color", color)
            startActivity(intent)
        }
    }

    private fun getColorRGB(): String {
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

    fun openColorPickerDialogue() {
        val colorPickerDialogue = AmbilWarnaDialog(this, defaultColor,
            object : AmbilWarnaDialog.OnAmbilWarnaListener {
                override fun onCancel(dialog: AmbilWarnaDialog?) {}

                override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                    defaultColor = color
                    binding?.colorPickerSelector?.setBackgroundColor(defaultColor)
                }
            })
        colorPickerDialogue.show()
    }

    private fun enableRGB(): String {
        binding?.iconRed?.visibility = View.VISIBLE
        binding?.inputRed?.visibility = View.VISIBLE
        binding?.iconGreen?.visibility = View.VISIBLE
        binding?.inputGreen?.visibility = View.VISIBLE
        binding?.iconBlue?.visibility = View.VISIBLE
        binding?.inputBlue?.visibility = View.VISIBLE

        binding?.colorPickerSelector?.visibility = View.GONE

        return "RGB"
    }

    private fun enablePicker(): String {
        binding?.colorPickerSelector?.visibility = View.VISIBLE

        binding?.iconRed?.visibility = View.GONE
        binding?.inputRed?.visibility = View.GONE
        binding?.iconGreen?.visibility = View.GONE
        binding?.inputGreen?.visibility = View.GONE
        binding?.iconBlue?.visibility = View.GONE
        binding?.inputBlue?.visibility = View.GONE

        return "picker"
    }
}