package com.fiap.bancodedados

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class Book(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var name: String,

    @ColumnInfo(name = "Published_Autor")
    var author: String,
)



