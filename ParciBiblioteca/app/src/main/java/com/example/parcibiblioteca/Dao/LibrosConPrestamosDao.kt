package com.example.parcibiblioteca.Dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcibiblioteca.Entity.LibrosConPrestamos

@Dao
interface LibrosConPrestamosDao {
    @Transaction
    @Query(
        """
        SELECT * FROM libros
        """
    )
    suspend fun getLibrosConPrestamos(): List<LibrosConPrestamos>

    @Transaction
    @Query(
        """
        SELECT * FROM libros
        WHERE libro_id = :libroId
        """
    )
    suspend fun getLibroConPrestamos(libroId: Long): LibrosConPrestamos
}