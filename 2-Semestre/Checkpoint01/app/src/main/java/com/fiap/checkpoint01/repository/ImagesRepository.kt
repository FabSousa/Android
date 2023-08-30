package com.fiap.checkpoint01.repository

import com.fiap.checkpoint01.R

class ImagesRepository {
    fun getImages(): ArrayList<Int>{
        val images = ArrayList<Int>()
        images.add(R.drawable.ic_abdominal_crunch)
        images.add(R.drawable.ic_high_knees_running_in_place)
        images.add(R.drawable.ic_jumping_jacks)
        images.add(R.drawable.ic_lunge)
        images.add(R.drawable.ic_plank)
        images.add(R.drawable.ic_push_up)
        images.add(R.drawable.ic_push_up_and_rotation)
        images.add(R.drawable.ic_side_plank)
        images.add(R.drawable.ic_squat)
        images.add(R.drawable.ic_step_up_onto_chair)
        images.add(R.drawable.ic_triceps_dip_on_chair)
        images.add(R.drawable.ic_wall_sit)
        return images
    }
}