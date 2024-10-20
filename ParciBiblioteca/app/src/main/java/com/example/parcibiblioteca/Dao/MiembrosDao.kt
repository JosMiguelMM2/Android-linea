package com.example.parcibiblioteca.Dao

import androidx.room.*
import com.example.parcibiblioteca.Entity.Miembros

@Dao
interface MiembrosDao {
    @Insert
    suspend fun insertMiembros(miembros: Miembros)

    @Query("SELECT * FROM miembros")
    suspend fun getAllMiembros(): List<Miembros>

    @Query("SELECT * FROM miembros WHERE miembro_id = :id")
    suspend fun getMiembrosById(id: Int): Miembros?

    @Query("SELECT * FROM miembros WHERE nombre = :nombre")
    suspend fun getMiembrosByNombre(nombre: String): Miembros?

    @Update
    suspend fun updateMiembros(miembros: Miembros)

    @Delete
    suspend fun deleteMiembros(miembros: Miembros)
}