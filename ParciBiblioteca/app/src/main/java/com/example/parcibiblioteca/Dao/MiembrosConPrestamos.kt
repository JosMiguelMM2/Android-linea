package com.example.parcibiblioteca.Dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcibiblioteca.Entity.MiembrosConPrestamos

@Dao
interface MiembrosConPrestamosDao {
    @Transaction
    @Query(
        """
        SELECT * FROM miembros
        """
    )
    suspend fun getMiembrosConPrestamos(): List<MiembrosConPrestamos>

    @Transaction
    @Query(
        """
        SELECT * FROM miembros
        WHERE miembro_id = :miembroId
        """
    )
    suspend fun getMiembroConPrestamos(miembroId: Long): MiembrosConPrestamos
}