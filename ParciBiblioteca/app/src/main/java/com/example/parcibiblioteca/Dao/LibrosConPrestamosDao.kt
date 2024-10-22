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
        SELECT 
            libros.*,
            prestamos.*
        FROM libros
        LEFT JOIN prestamos ON libros.libro_id = prestamos.libro_id
        """
    )
    suspend fun getLibrosConPrestamos(): List<LibrosConPrestamos>

    @Transaction
    @Query(
        """
        SELECT 
            libros.*,
            prestamos.*
        FROM libros
        LEFT JOIN prestamos ON libros.libro_id = prestamos.libro_id
        WHERE libros.libro_id = :libroId
        """
    )
    suspend fun getLibroConPrestamos(libroId: Long): LibrosConPrestamos
}