package com.example.parcibiblioteca.Dao

import androidx.room.*
import com.example.parcibiblioteca.Entity.Autores

@Dao
interface AutoresDao {
    @Insert
    suspend fun insertAutores(autores: Autores)

    @Query("SELECT * FROM autores")
    suspend fun getAllAutores(): List<Autores>

    @Query("SELECT * FROM autores WHERE autor_id = :id")
    suspend fun getAutoresById(id: Int): Autores?

    @Update
    suspend fun updateAutores(autores: Autores)

    @Delete
    suspend fun deleteAutores(autores: Autores)
}