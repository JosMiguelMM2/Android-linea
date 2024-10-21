package com.example.parcibiblioteca.Model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parcibiblioteca.Entity.AutoresConLibros
import com.example.parcibiblioteca.Repository.AutoresConLibrosRepository
import kotlinx.coroutines.launch

class AutoresConLibrosModel(private val repository: AutoresConLibrosRepository) : ViewModel() {

    val autoresConLibros = mutableStateOf<List<AutoresConLibros>>(emptyList())

    fun fetchAutoresConLibros() {
        viewModelScope.launch {
            val data = repository.getAutoresConLibros()
            val groupedData = data.groupBy { it.autor }
                .map { (autor, librosConAutores) ->
                    AutoresConLibros(autor, librosConAutores.flatMap { it.libros })
                }
            autoresConLibros.value = groupedData
        }
    }

    fun fetchLibroByTitle(titulo: String) {
        viewModelScope.launch {
            val libro = repository.getLibroTitle(titulo)
            autoresConLibros.value = listOf(libro)
        }
    }
}

class AutoresConLibrosModelFactory(
    private val repository: AutoresConLibrosRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AutoresConLibrosModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AutoresConLibrosModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}