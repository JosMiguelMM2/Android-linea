package com.example.plantilla.data

import kotlinx.coroutines.flow.Flow

interface ContactoRepository {
    fun getAllContacts(): Flow<List<Contacto>>
    fun getContact(telefono: String): Flow<Contacto>
    suspend fun insert(contacto: Contacto)
    suspend fun update(contacto: Contacto)
    suspend fun delete(contacto: Contacto)
}

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
    fun getContact(telefono: String): Flow<Contacto> {
        return contactoDao.getContact(telefono)
    }

    fun getContacto(telefono: String): Flow<Contacto> {
        return contactoDao.getContact(telefono)
    }
}