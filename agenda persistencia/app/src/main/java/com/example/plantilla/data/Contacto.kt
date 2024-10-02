package com.example.plantilla.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class Contacto(
    val nombre: String,
    val apellido: String,
    @PrimaryKey val telefono: String,
    val hobby: String
)
