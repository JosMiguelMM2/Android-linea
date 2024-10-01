package com.example.plantilla.Repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.plantilla.Entity.Contactos

@Dao
interface RepositoryContacto {
    @Insert
    suspend fun insertContacto(contacto: Contactos)

    @Query("SELECT * FROM contactos")
    suspend fun getContactos(): List<Contactos>

    @Query("DELETE FROM contactos WHERE telefono = :telefono")
    suspend fun deleteContacto(telefono: Long)

    @Query("UPDATE contactos SET nombre = :nombre, apellido = :apellido, hobby = :hobby WHERE telefono = :telefono")
    suspend fun updateContacto(nombre: String, apellido: String, hobby: String, telefono: Long)

    @Query("SELECT * FROM contactos WHERE telefono = :telefono")
    suspend fun getContacto(telefono: Long): Contactos

    @Query("SELECT * FROM contactos WHERE nombre = :nombre")
    suspend fun getContactoNombre(nombre: String): Contactos
}