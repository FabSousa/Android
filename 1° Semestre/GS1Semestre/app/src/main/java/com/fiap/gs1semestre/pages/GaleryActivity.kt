package com.fiap.gs1semestre.pages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fiap.gs1semestre.MainActivity
import com.fiap.gs1semestre.R
import com.fiap.gs1semestre.adapter.GaleryAdapter
import com.fiap.gs1semestre.model.PhotoModel
import com.fiap.gs1semestre.repository.PhotoRepository

class GaleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galery)

        val returnButton = findViewById<Button>(R.id.returnButton)
        val photos = getPhotos()
        val reciclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = GaleryAdapter(this, photos)

        reciclerView.layoutManager = LinearLayoutManager(this)
        reciclerView.setHasFixedSize(true)
        reciclerView.adapter = adapter

        returnButton.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun getPhotos(): List<PhotoModel>{
        val type = intent.extras?.getString("type")
        if(type == "Trigo"){
            return PhotoRepository().getTrigo()
        }
        if(type == "Milho"){
            return PhotoRepository().getMilho()
        }

        return PhotoRepository().getSoja()
    }

}