package com.example.homeacademy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeacademy.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(val items : ArrayList<ExerciseModel>) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        val model : ExerciseModel = items[position]
        holder.tvItem.text = model.getId().toString()
    }

    override fun getItemCount() : Int {
        return items.size
    }

    class ViewHolder(binding : ItemExerciseStatusBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }
}