package com.example.gestordevehiculos.Dao

import androidx.room.*
import com.example.gestordevehiculos.Entity.Coche

@Dao
interface CocheDao {
    @Insert
    suspend fun insertCoche(coche: Coche): Long

    @Query("SELECT * FROM coche")
    suspend fun getAllCoches(): List<Coche>

    @Query("SELECT * FROM coche WHERE IdCoche = :id")
    suspend fun getCocheById(id: Int): Coche?

    @Update
    suspend fun updateCoche(coche: Coche)

    @Delete
    suspend fun deleteCoche(coche: Coche)
}