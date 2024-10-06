package com.example.plantilla.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantilla.data.Contacto
import com.example.plantilla.data.ContactoRepository1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ModelContacto(private val repository: ContactoRepository1) : ViewModel() {

    private val _contactos = MutableStateFlow<List<Contacto>>(emptyList())

    fun getAllContacts() {
        viewModelScope.launch {
            repository.getAllContacts().collect {
                _contactos.value = it
            }
        }
    }

    fun insert(contacto: Contacto) {
        viewModelScope.launch {
            repository.insert(contacto)
        }
    }

    fun update(contacto: Contacto) {
        viewModelScope.launch {
            repository.update(contacto)
        }
    }

    fun delete(contacto: Contacto) {
        viewModelScope.launch {
            repository.delete(contacto)
        }
    }

}