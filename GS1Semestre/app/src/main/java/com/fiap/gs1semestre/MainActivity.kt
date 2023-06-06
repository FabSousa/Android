package com.fiap.gs1semestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fiap.gs1semestre.model.PhotoModel
import com.fiap.gs1semestre.repository.PhotoRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, GaleryActivity::class.java)

        val trigoButton = findViewById<Button>(R.id.trigoButton)
        val milhoButton = findViewById<Button>(R.id.milhoButton)
        val sojaButton = findViewById<Button>(R.id.sojaButton)

        var bundle = Bundle()

        trigoButton.setOnClickListener(){
            bundle.putString("type", "Trigo")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        milhoButton.setOnClickListener(){
            bundle.putString("type", "Milho")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        sojaButton.setOnClickListener(){
            bundle.putString("type", "Soja")
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}