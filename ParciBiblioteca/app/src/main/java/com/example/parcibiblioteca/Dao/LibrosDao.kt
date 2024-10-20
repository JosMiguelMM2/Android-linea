package com.example.parcibiblioteca.Dao

import androidx.room.*
import com.example.parcibiblioteca.Entity.Libros

@Dao
interface LibrosDao {
    @Insert
    suspend fun insertLibros(libros: Libros)

    @Query("SELECT * FROM libros")
    suspend fun getAllLibros(): List<Libros>

    @Query("SELECT * FROM libros WHERE libro_id = :id")
    suspend fun getLibrosById(id: Int): Libros?

    @Update
    suspend fun updateLibros(libros: Libros)

    @Delete
    suspend fun deleteLibros(libros: Libros)
}