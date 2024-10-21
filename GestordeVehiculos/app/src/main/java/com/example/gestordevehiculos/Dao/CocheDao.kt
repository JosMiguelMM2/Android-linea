package com.example.gestordevehiculos.Dao

import androidx.room.*
import com.example.gestordevehiculos.Entity.Coche
import com.example.gestordevehiculos.Entity.CochePersonaDetails
import com.example.gestordevehiculos.Entity.PersonaConCoche

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

    @Query(
        """
    SELECT coche.Matricula, coche.Marca, coche.Modelo, coche.Caballos, persona.Nombre, persona.Apellido
    FROM coche
    INNER JOIN persona ON coche.idPersona = persona.idPersona
"""
    )
    suspend fun getCocheWithPersonaDetails(): List<CochePersonaDetails>

}