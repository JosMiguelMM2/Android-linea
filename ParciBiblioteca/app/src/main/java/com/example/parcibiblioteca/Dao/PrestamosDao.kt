package com.example.parcibiblioteca.Dao

import androidx.room.*
import com.example.parcibiblioteca.Entity.Prestamos

@Dao
interface PrestamosDao {
    @Insert
    suspend fun insertPrestamos(prestamos: Prestamos)

    @Query("SELECT * FROM prestamos")
    suspend fun getAllPrestamos(): List<Prestamos>

    @Query("SELECT * FROM prestamos WHERE prestamo_id = :id")
    suspend fun getPrestamosById(id: Int): Prestamos?

    @Update
    suspend fun updatePrestamos(prestamos: Prestamos)

    @Delete
    suspend fun deletePrestamos(prestamos: Prestamos)
}