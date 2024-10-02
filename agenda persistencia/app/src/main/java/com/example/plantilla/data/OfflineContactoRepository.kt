package com.example.plantilla.data

import kotlinx.coroutines.flow.Flow

class OfflineContactoRepository(private val contactoDao: ContactoDao) : ContactoRepository {
    override fun getAllContacts(): Flow<List<Contacto>> = contactoDao.getAllContacts()
    override fun getContact(telefono: String): Flow<Contacto> = contactoDao.getContact(telefono)
    override suspend fun insert(contacto: Contacto) = contactoDao.insert(contacto)
    override suspend fun update(contacto: Contacto) = contactoDao.update(contacto)
    override suspend fun delete(contacto: Contacto) = contactoDao.delete(contacto)
}