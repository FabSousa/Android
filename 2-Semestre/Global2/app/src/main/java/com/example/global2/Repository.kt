package com.example.global2
import java.util.*

object Repository {
    fun defaultImageList() : ArrayList<ImageModel>{
        val imageList = ArrayList<ImageModel>()
            val img1 = ImageModel(1,"img1",R.drawable.img1)
            val img2 = ImageModel(2,"img2",R.drawable.img2)
            val img3 = ImageModel(3,"img3",R.drawable.img3)
            val img4 = ImageModel(4,"img4",R.drawable.img4)
            val img5 = ImageModel(5,"img5",R.drawable.img5)

        imageList.add(img1)
        imageList.add(img2)
        imageList.add(img3)
        imageList.add(img4)
        imageList.add(img5)

        return imageList
    }

}