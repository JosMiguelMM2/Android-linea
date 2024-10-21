// MiembrosViewModel.kt
package com.example.parcibiblioteca.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parcibiblioteca.Entity.Miembros
import com.example.parcibiblioteca.Repository.MiembrosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MiembrosViewModel(private val miembrosRepository: MiembrosRepository) : ViewModel() {
    private val _miembros = MutableStateFlow<List<Miembros>>(emptyList())
    val miembros: StateFlow<List<Miembros>> = _miembros

    fun loadMiembros() {
        viewModelScope.launch {
            _miembros.value = miembrosRepository.getAllMiembros()
        }
    }
}

class MiembrosViewModelFactory(private val miembrosRepository: MiembrosRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MiembrosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MiembrosViewModel(miembrosRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}