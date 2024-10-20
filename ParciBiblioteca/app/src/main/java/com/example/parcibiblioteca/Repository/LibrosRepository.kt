package com.example.parcibiblioteca.Repository

import com.example.parcibiblioteca.Dao.LibrosDao
import com.example.parcibiblioteca.Entity.Libros

class LibrosRepository(private val librosDao: LibrosDao) {

    suspend fun insertLibros(libros: Libros) {
        librosDao.insertLibros(libros)
    }

    suspend fun getAllLibros(): List<Libros> {
        return librosDao.getAllLibros()
    }

    suspend fun getLibrosById(id: Int): Libros? {
        return librosDao.getLibrosById(id)
    }

    suspend fun updateLibros(libros: Libros) {
        librosDao.updateLibros(libros)
    }

    suspend fun deleteLibros(libros: Libros) {
        librosDao.deleteLibros(libros)
    }
}