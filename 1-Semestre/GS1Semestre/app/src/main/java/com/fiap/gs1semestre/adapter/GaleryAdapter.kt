package com.fiap.gs1semestre.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fiap.gs1semestre.R
import com.fiap.gs1semestre.model.PhotoModel

class GaleryAdapter(private val context: Context, private  val photos: List<PhotoModel>) :
    RecyclerView.Adapter<GaleryAdapter.ViewHolder>()  {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo = itemView.findViewById<ImageView>(R.id.photo)
        val id = itemView.findViewById<TextView>(R.id.idText)
        val cultura= itemView.findViewById<TextView>(R.id.culturaText)
        val data= itemView.findViewById<TextView>(R.id.dataText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.galery_row, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.photo.setImageResource(photos[position].img)
        holder.id.text = String.format("ID: %s", photos[position].id.toString())
        holder.cultura.text = String.format("Cultura: %s", photos[position].cultura)
        holder.data.text = String.format("Data: %s", photos[position].detaPlantio)
    }

    override fun getItemCount() = photos.size

}