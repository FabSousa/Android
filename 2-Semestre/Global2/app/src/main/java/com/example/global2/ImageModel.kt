package com.example.global2

class ImageModel(private var id: Int,
private var name: String,
private var image: Int) {
    fun GetId(): Int{
        return id
    }
    fun GetImg(): Int{
        return image
    }
    fun GetName(): String{
        return name
    }
}