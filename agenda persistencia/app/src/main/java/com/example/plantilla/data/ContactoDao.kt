package com.example.plantilla.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactoDao {

    @Query("SELECT * from contactos ORDER BY nombre ASC")
    fun getAllContacts(): Flow<List<Contacto>>

    @Query("SELECT * from contactos WHERE telefono = :telefono")
    suspend fun getContact(telefono: String): Contacto

    @Insert
    suspend fun insert(contacto: Contacto)

    @Update
    suspend fun update(contacto: Contacto)

    @Delete
    suspend fun delete(contacto: Contacto)

    @Query("SELECT * FROM contactos WHERE nombre LIKE :name")
    fun search(name: String): Flow<List<Contacto>>
}