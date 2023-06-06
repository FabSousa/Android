package com.fiap.gs1semestre

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GaleryAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<GaleryAdapter.ViewHolder>()  {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = dataSet.size

}