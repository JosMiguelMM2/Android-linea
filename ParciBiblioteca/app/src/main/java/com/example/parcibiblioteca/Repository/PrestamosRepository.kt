package com.example.parcibiblioteca.Repository

import com.example.parcibiblioteca.Dao.PrestamosDao
import com.example.parcibiblioteca.Entity.Prestamos

class PrestamosRepository(private val prestamosDao: PrestamosDao) {

    suspend fun insertPrestamos(prestamos: Prestamos) {
        prestamosDao.insertPrestamos(prestamos)
    }

    suspend fun getAllPrestamos(): List<Prestamos> {
        return prestamosDao.getAllPrestamos()
    }

    suspend fun getPrestamosById(id: Int): Prestamos? {
        return prestamosDao.getPrestamosById(id)
    }

    suspend fun updatePrestamos(prestamos: Prestamos) {
        prestamosDao.updatePrestamos(prestamos)
    }

    suspend fun deletePrestamos(prestamos: Prestamos) {
        prestamosDao.deletePrestamos(prestamos)
    }
}