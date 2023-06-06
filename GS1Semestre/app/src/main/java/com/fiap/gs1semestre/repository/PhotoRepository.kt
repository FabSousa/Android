package com.fiap.gs1semestre.repository

import com.fiap.gs1semestre.R
import com.fiap.gs1semestre.model.PhotoModel

class PhotoRepository {

    fun getMilho(): List<PhotoModel>{
        return listOf(PhotoModel(id = 1, img = R.drawable.milho1, cultura = "Milho", detaPlantio = "12/03/23"),
            PhotoModel(id = 2, img = R.drawable.milho2, cultura = "Milho", detaPlantio = "05/03/23"),
            PhotoModel(id = 3, img = R.drawable.milho3, cultura = "Milho", detaPlantio = "19/04/23"),
            PhotoModel(id = 4, img = R.drawable.milho4, cultura = "Milho", detaPlantio = "12/12/22"),
            PhotoModel(id = 5, img = R.drawable.milho5, cultura = "Milho", detaPlantio = "28/01/23"),
        )
    }

    fun getSoja(): List<PhotoModel>{
        return listOf(PhotoModel(id = 6, img = R.drawable.soja1, cultura = "Soja", detaPlantio = "06/01/23"),
            PhotoModel(id = 7, img = R.drawable.soja2, cultura = "Soja", detaPlantio = "29/11/22"),
            PhotoModel(id = 8, img = R.drawable.soja3, cultura = "Soja", detaPlantio = "25/12/22"),
            PhotoModel(id = 9, img = R.drawable.soja4, cultura = "Soja", detaPlantio = "18/03/23"),
            PhotoModel(id = 10, img = R.drawable.soja5, cultura = "Soja", detaPlantio = "01/01/23"),
        )
    }

    fun getTrigo(): List<PhotoModel>{
        return listOf(PhotoModel(id = 11, img = R.drawable.trigo1, cultura = "Trigo", detaPlantio = "28/04/23"),
            PhotoModel(id = 12, img = R.drawable.trigo2, cultura = "Trigo", detaPlantio = "11/02/23"),
            PhotoModel(id = 13, img = R.drawable.trigo3, cultura = "Trigo", detaPlantio = "19/10/22"),
            PhotoModel(id = 14, img = R.drawable.trigo4, cultura = "Trigo", detaPlantio = "19/01/23"),
            PhotoModel(id = 15, img = R.drawable.trigo5, cultura = "Trigo", detaPlantio = "06/11/22"),

        )
    }
}