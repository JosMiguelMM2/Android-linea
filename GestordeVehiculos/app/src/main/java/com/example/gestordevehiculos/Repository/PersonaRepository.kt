package com.example.gestordevehiculos.Repository

import com.example.gestordevehiculos.Dao.PersonaDao
import com.example.gestordevehiculos.Entity.Persona

class PersonaRepository(private val personaDao: PersonaDao){
    suspend fun insertPersona(persona: Persona) = personaDao.insertPersona(persona)

    suspend fun getAllPersonas() = personaDao.getAllPersonas()

    suspend fun getPersonaById(id: Int) = personaDao.getPersonaById(id)

    suspend fun updatePersona(persona: Persona) = personaDao.updatePersona(persona)

    suspend fun deletePersona(persona: Persona) = personaDao.deletePersona(persona)
}