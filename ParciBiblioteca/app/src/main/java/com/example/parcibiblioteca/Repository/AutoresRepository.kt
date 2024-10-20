package com.example.parcibiblioteca.Repository

import com.example.parcibiblioteca.Dao.AutoresDao
import com.example.parcibiblioteca.Entity.Autores

class AutoresRepository(private val autoresDao: AutoresDao) {
    suspend fun insertAutor(autor: Autores) = autoresDao.insertAutores(autor)

    suspend fun getAllAutores() = autoresDao.getAllAutores()

    suspend fun getAutorById(id: Int) = autoresDao.getAutoresById(id)

    suspend fun updateAutor(autor: Autores) = autoresDao.updateAutores(autor)

    suspend fun deleteAutor(autor: Autores) = autoresDao.deleteAutores(autor)
}