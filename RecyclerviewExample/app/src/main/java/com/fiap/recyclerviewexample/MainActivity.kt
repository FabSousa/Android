package com.fiap.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fiap.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var nameList: MutableList<SampleModel> = mutableListOf()
    private lateinit var sampleAdapter: SampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        sampleAdapter = SampleAdapter(nameList)
        binding.apply {
            rvMain.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = sampleAdapter
            }
        }
    }

    fun loadData() {
        nameList.add(SampleModel(1,"Sample Title"))
        nameList.add(SampleModel(2,"Sample 1"))
        nameList.add(SampleModel(3,"Sample 2"))
        nameList.add(SampleModel(4,"Sample 3"))
        nameList.add(SampleModel(5,"Sample 4"))
        nameList.add(SampleModel(6,"Sample 5"))
    }
}