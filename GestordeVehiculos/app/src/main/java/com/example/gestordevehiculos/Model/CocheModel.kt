package com.example.gestordevehiculos.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gestordevehiculos.Repository.CocheRepository
import androidx.lifecycle.viewModelScope
import com.example.gestordevehiculos.Entity.Coche
import kotlinx.coroutines.launch

class CocheModel(private val cocheRepository: CocheRepository) : ViewModel() {

    fun insertCoche(coche: Coche) {
        viewModelScope.launch {
            cocheRepository.insertCoche(coche)
        }
    }

    fun getAllCoches() {
        viewModelScope.launch {
            cocheRepository.getAllCoches()
        }
    }

    fun getCocheById(id: Int) {
        viewModelScope.launch {
            cocheRepository.getCocheById(id)
        }
    }

    fun updateCoche(coche: Coche) {
        viewModelScope.launch {
            cocheRepository.updateCoche(coche)
        }
    }

    fun deleteCoche(coche: Coche) {
        viewModelScope.launch {
            cocheRepository.deleteCoche(coche)
        }
    }

    fun getCocheWithPersonaDetails() {
        viewModelScope.launch {
            cocheRepository.getCocheWithPersonaDetails()
        }
    }
}

class CocheModelFactory(private val cocheRepository: CocheRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocheModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CocheModel(cocheRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}