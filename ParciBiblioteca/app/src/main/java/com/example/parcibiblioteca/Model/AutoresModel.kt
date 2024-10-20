package com.example.parcibiblioteca.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.parcibiblioteca.Entity.Autores
import com.example.parcibiblioteca.Repository.AutoresRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AutoresViewModel(private val autoresRepository: AutoresRepository) : ViewModel() {
    private val _autores = MutableStateFlow<List<Autores>>(emptyList())
    val autores: StateFlow<List<Autores>> = _autores

    fun loadAutores() {
        viewModelScope.launch {
            _autores.value = autoresRepository.getAllAutores()
        }
    }
}

class AutoresViewModelFactory(private val autoresRepository: AutoresRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AutoresViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AutoresViewModel(autoresRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}