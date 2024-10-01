package com.example.plantilla.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class Contactos(
    @PrimaryKey val telefono: Long = 0,
    val nombre: String,
    val apellido: String,
    val hobby: String
)
