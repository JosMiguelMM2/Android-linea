package com.example.plantilla.Model

import com.example.plantilla.Database.AppDatabase
import com.example.plantilla.Entity.Contactos

class ContactoModel(private val database: AppDatabase) {


    suspend fun insertContacto(contacto: Contactos) {
        database.contactDao().insertContacto(contacto)
    }

    suspend fun getContactos(): List<Contactos> {
        return database.contactDao().getContactos()
    }

    suspend fun deleteContacto(telefono: Long) {
        database.contactDao().deleteContacto(telefono)
    }

    suspend fun updateContacto(nombre: String, apellido: String, hobby: String, telefono: Long) {
        database.contactDao().updateContacto(nombre, apellido, hobby, telefono)
    }

    suspend fun getContacto(telefono: Long): Contactos {
        return database.contactDao().getContacto(telefono)
    }

    suspend fun getContactoNombre(nombre: String): Contactos {
        return database.contactDao().getContactoNombre(nombre)
    }
}