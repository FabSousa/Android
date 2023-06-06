package com.fiap.gs1semestre.repository

import com.fiap.gs1semestre.model.PhotoModel

class PhotoRepository {

    fun getTrigo(): List<PhotoModel>{
        return listOf(PhotoModel(id = 1, cultura = "@string/CulturaSoja", producao = 10.0),
            PhotoModel(id = 2, cultura = "@string/CulturaSoja", producao = 10.0),
        )
    }

    fun getMilho(): List<PhotoModel>{
        return listOf(PhotoModel(id = 1, cultura = "@string/CulturaSoja", producao = 10.0),
            PhotoModel(id = 2, cultura = "@string/CulturaSoja", producao = 10.0),
        )
    }

    fun getSoja(): List<PhotoModel>{
        return listOf(PhotoModel(id = 1, cultura = "@string/CulturaSoja", producao = 10.0),
            PhotoModel(id = 2, cultura = "@string/CulturaSoja", producao = 10.0),
        )
    }
}