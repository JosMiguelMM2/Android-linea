package com.example.parcibiblioteca.Dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcibiblioteca.Entity.AutoresConLibros

@Dao
interface AutoresConLibrosDao {
    @Transaction
    @Query(
        """
        SELECT autores.*, libros.libro_id, libros.titulo, libros.genero, libros.autor_id
        FROM autores
        INNER JOIN libros ON autores.autor_id = libros.autor_id
    """
    )
    suspend fun getAutoresConLibros(): List<AutoresConLibros>

    @Transaction
    @Query(
        """
        SELECT autores.*, libros.libro_id, libros.titulo, libros.genero, libros.autor_id
        FROM autores
        INNER JOIN libros ON autores.autor_id = libros.autor_id
        WHERE autores.autor_id = :autorId
    """
    )
    suspend fun getAutorConLibros(autorId: Long): AutoresConLibros
}