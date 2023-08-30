package com.fiap.checkpoint01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fiap.checkpoint01.databinding.Activity02Binding
import com.fiap.checkpoint01.repository.ImagesRepository

class Activity02 : AppCompatActivity() {
    private var binding: Activity02Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = Activity02Binding.inflate(layoutInflater)
        setContentView(binding?.root)

        val images = ImagesRepository().getImages()
        var i = intent.getIntExtra("img", 0)

        binding?.imageView2?.setImageResource(images[i])

        binding?.button?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}