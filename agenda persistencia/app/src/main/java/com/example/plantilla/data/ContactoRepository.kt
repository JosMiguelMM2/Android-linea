package com.example.plantilla.data

import kotlinx.coroutines.flow.Flow

interface ContactoRepository {
    fun getAllContacts(): Flow<List<Contacto>>
    fun getContact(telefono: String): Flow<Contacto>
    suspend fun insert(contacto: Contacto)
    suspend fun update(contacto: Contacto)
    suspend fun delete(contacto: Contacto)
}