package com.example.gestordevehiculos.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gestordevehiculos.Entity.Persona
import com.example.gestordevehiculos.Repository.PersonaRepository
import kotlinx.coroutines.launch

class PersonaModel(private val personaRepository: PersonaRepository) : ViewModel() {
    fun insertPersona(persona: Persona) {
        viewModelScope.launch {
            personaRepository.insertPersona(persona)
        }
    }

    fun getAllPersonas() {
        viewModelScope.launch {
            personaRepository.getAllPersonas()
        }
    }

    fun getPersonaById(id: Int) {
        viewModelScope.launch {
            personaRepository.getPersonaById(id)
        }
    }

    fun updatePersona(persona: Persona) {
        viewModelScope.launch {
            personaRepository.updatePersona(persona)
        }
    }

    fun deletePersona(persona: Persona) {
        viewModelScope.launch {
            personaRepository.deletePersona(persona)
        }
    }
}

class PersonaViewModelFactory(private val personaRepository: PersonaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonaModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PersonaModel(personaRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}