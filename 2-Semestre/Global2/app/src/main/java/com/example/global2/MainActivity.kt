package com.example.global2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.global2.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var timer : CountDownTimer? = null
    private var currentImagePosition = 0;
    private var binding : ActivityMainBinding? = null;
    private var imageList : ArrayList<ImageModel>? = null
    private val duration : Long = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageList = Repository.defaultImageList()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setupImages()

        binding?.button?.setOnClickListener {
            timer?.cancel()

            currentImagePosition++

            if (currentImagePosition >= imageList!!.size){
                currentImagePosition = 0
            }

            binding?.textView?.text = imageList!![currentImagePosition].GetName()
            binding?.imageView?.setImageResource(imageList!![currentImagePosition].GetImg())

            setProgress()
        }

    }


    private fun setupImages(){
        if (timer != null){
            timer?.cancel()
        }

        binding?.textView?.text = imageList!![currentImagePosition].GetName()
        binding?.imageView?.setImageResource(imageList!![currentImagePosition].GetImg())
        setProgress()
    }

    private fun setProgress(){
        timer = object : CountDownTimer(duration * 1000, 1000){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                currentImagePosition++

                if (currentImagePosition >= imageList!!.size){
                    currentImagePosition = 0
                }

                setupImages()
            }
        }.start()
    }




}