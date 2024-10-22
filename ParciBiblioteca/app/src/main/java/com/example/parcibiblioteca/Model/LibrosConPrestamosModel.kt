package com.example.parcibiblioteca.Model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parcibiblioteca.Entity.LibrosConPrestamos
import com.example.parcibiblioteca.Repository.LibrosConPrestamosRepository
import kotlinx.coroutines.launch

class LibrosConPrestamosModel(private val repository: LibrosConPrestamosRepository) : ViewModel() {

    val librosConPrestamos = mutableStateOf<List<LibrosConPrestamos>>(emptyList())

    fun fetchLibrosConPrestamos() {
        viewModelScope.launch {
            val data = repository.getLibrosConPrestamos()
            val groupedData = data.groupBy { it.libro }
                .map { (libro, prestamos) ->
                    LibrosConPrestamos(libro, prestamos.flatMap { it.prestamos }.distinctBy { it.prestamo_id })
                }
            librosConPrestamos.value = groupedData
        }
    }

    fun fetchLibroConPrestamos(libroId: Long) {
        viewModelScope.launch {
            val libroConPrestamos = repository.getLibroConPrestamos(libroId)
            librosConPrestamos.value = listOf(libroConPrestamos)
        }
    }
}

class LibrosConPrestamosModelFactory(
    private val repository: LibrosConPrestamosRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LibrosConPrestamosModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LibrosConPrestamosModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}