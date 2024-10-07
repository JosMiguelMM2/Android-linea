package com.example.plantilla.data

import kotlinx.coroutines.flow.Flow

class ContactoRepository1(private val contactoDao: ContactoDao) {
    suspend fun insert(contacto: Contacto) {
        contactoDao.insert(contacto)
    }

    suspend fun update(contacto: Contacto) {
        contactoDao.update(contacto)
    }

    suspend fun delete(contacto: Contacto) {
        contactoDao.delete(contacto)
    }

    fun getAllContacts(): Flow<List<Contacto>> {
        return contactoDao.getAllContacts()
    }

    suspend fun getContact(telefono: String): Contacto {
        return contactoDao.getContact(telefono)
    }

    fun search(name: String): Flow<List<Contacto>> {
        return contactoDao.search(name)
    }
}