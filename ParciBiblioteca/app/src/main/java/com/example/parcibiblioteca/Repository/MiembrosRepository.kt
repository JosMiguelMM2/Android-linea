package com.example.parcibiblioteca.Repository

import com.example.parcibiblioteca.Dao.MiembrosDao
import com.example.parcibiblioteca.Entity.Miembros

class MiembrosRepository(private val miembrosDao: MiembrosDao) {

    suspend fun insertMiembros(miembros: Miembros) = miembrosDao.insertMiembros(miembros)

    suspend fun getAllMiembros(): List<Miembros> = miembrosDao.getAllMiembros()

    suspend fun getMiembrosById(id: Int): Miembros? = miembrosDao.getMiembrosById(id)

    suspend fun getMiembrosByNombre(nombre: String): Miembros? = miembrosDao.getMiembrosByNombre(nombre)

    suspend fun updateMiembros(miembros: Miembros) = miembrosDao.updateMiembros(miembros)

    suspend fun deleteMiembros(miembros: Miembros) = miembrosDao.deleteMiembros(miembros)
}