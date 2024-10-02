package com.example.plantilla.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactoDao {

    @Query("SELECT * from contactos ORDER BY nombre ASC")
    fun getAllContacts(): Flow<List<Contacto>>

    @Query("SELECT * from contactos WHERE telefono = :telefono")
    fun getContact(telefono: String): Flow<Contacto>

    @Insert
    suspend fun insert(contacto: Contacto)

    @Update
    suspend fun update(contacto: Contacto)

    @Delete
    suspend fun delete(contacto: Contacto)

}