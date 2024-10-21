package com.example.parcibiblioteca.Repository

import com.example.parcibiblioteca.Dao.AutoresConLibrosDao
import com.example.parcibiblioteca.Entity.AutoresConLibros

class AutoresConLibrosRepository(private val autoresConLibrosDao: AutoresConLibrosDao) {

    suspend fun getAutoresConLibros(): List<AutoresConLibros> {
        return autoresConLibrosDao.getAutoresConLibros()
    }

    suspend fun getLibroTitle(titulo: String): AutoresConLibros {
        return autoresConLibrosDao.getLibroTitle(titulo)
    }
}
