package com.example.gestordevehiculos.Dao

import androidx.room.*
import com.example.gestordevehiculos.Entity.Persona

@Dao
interface PersonaDao {
    @Insert
    suspend fun insertPersona(persona: Persona): Long

    @Query("SELECT * FROM persona")
    suspend fun getAllPersonas(): List<Persona>

    @Query("SELECT * FROM persona WHERE idPersona = :id")
    suspend fun getPersonaById(id: Int): Persona?

    @Update
    suspend fun updatePersona(persona: Persona)

    @Delete
    suspend fun deletePersona(persona: Persona)
}