package com.fiap.checkpoint01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fiap.checkpoint01.databinding.ActivityMainBinding
import com.fiap.checkpoint01.repository.ImagesRepository

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val images = ImagesRepository().getImages()
        var i = 0

        binding?.imageView?.setImageResource(images[0])

        binding?.button1?.setOnClickListener {
            i++
            if(i >= images.size){
                i = 0
            }
            binding?.imageView?.setImageResource(images[i])
        }

        binding?.button2?.setOnClickListener {
            val intent = Intent(this, Activity02::class.java)
            intent.putExtra("img", i)
            startActivity(intent)
        }
    }

}