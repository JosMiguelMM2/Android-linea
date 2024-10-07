package com.example.plantilla.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.plantilla.data.Contacto
import com.example.plantilla.data.ContactoRepository1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ModelContacto(private val repository: ContactoRepository1) : ViewModel() {

    private val _contactos = MutableStateFlow<List<Contacto>>(emptyList())
    val contactos: StateFlow<List<Contacto>> = _contactos

    private val _contacto = MutableStateFlow<Contacto?>(null)
    val contacto: StateFlow<Contacto?> = _contacto.asStateFlow()

    fun getAllContacts() {
        viewModelScope.launch {
            repository.getAllContacts().collect {
                _contactos.value = it
            }
        }
    }

    fun getContact(telefono: String) {
        viewModelScope.launch {
            val contact = repository.getContact(telefono)
            _contacto.value = contact
        }
    }

    fun search(name: String) {
        viewModelScope.launch {
            if (name.isNotEmpty()) {
                repository.search(name).collect { contactosList ->
                    _contactos.value = contactosList
                }
            } else {
                getAllContacts()
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
            getAllContacts()
        }
    }

}

class ContactViewModelFactory(
    private val contactoRepository1: ContactoRepository1
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ModelContacto::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ModelContacto(contactoRepository1) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}