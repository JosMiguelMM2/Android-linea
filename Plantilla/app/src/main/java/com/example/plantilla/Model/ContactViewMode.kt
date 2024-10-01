package com.example.plantilla.Model

import androidx.compose.runtime.mutableStateListOf
import com.example.plantilla.Database.AppDatabase
import com.example.plantilla.Entity.Contactos
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContactViewModel(private val database: AppDatabase):ViewModel() {
     private val contactoModel = ContactoModel(database)

    val contactList = mutableStateListOf<Contactos>()

    fun addContact(contacto: Contactos) {
        viewModelScope.launch {
            contactoModel.insertContacto(contacto)
            contactList.add(contacto)
        }
    }
}

class ContactViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}