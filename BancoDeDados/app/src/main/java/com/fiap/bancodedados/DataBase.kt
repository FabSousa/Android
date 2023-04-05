package com.fiap.bancodedados

import androidx.room.Database

@Database(entities = [Book::class], version = 1)
abstract class DataBase {
    abstract fun bookDao(): BookDao
}