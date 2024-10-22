package com.example.parcibiblioteca.Repository

import com.example.parcibiblioteca.Dao.LibrosConPrestamosDao
import com.example.parcibiblioteca.Entity.LibrosConPrestamos

class LibrosConPrestamosRepository(
    private val librosConPrestamosDao:
    LibrosConPrestamosDao
) {

    suspend fun getLibrosConPrestamos(): List<LibrosConPrestamos> {
        return librosConPrestamosDao.getLibrosConPrestamos()
    }

    suspend fun getLibroConPrestamos(libroId: Long): LibrosConPrestamos {
        return librosConPrestamosDao.getLibroConPrestamos(libroId)
    }
}