package com.example.parcibiblioteca.Model

import com.example.parcibiblioteca.Entity.Autores
import com.example.parcibiblioteca.Repository.AutoresRepository

class AutoresModel(private val repository: AutoresRepository) {

    suspend fun insertAutor(autor: Autores) {
        repository.insertAutor(autor)
    }

    suspend fun getAllAutores(): List<Autores> {
        return repository.getAllAutores()
    }

    suspend fun getAutorById(id: Int): Autores? {
        return repository.getAutorById(id)
    }

    suspend fun updateAutor(autor: Autores) {
        repository.updateAutor(autor)
    }

    suspend fun deleteAutor(autor: Autores) {
        repository.deleteAutor(autor)
    }
}