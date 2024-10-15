package com.example.gestordevehiculos.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persona")
data class Persona(
    @PrimaryKey(autoGenerate = true) val idPersona: Int = 0,
    val Nombre: String,
    val Apellido: String,
    val Apellido2: String,
    val DNI: String
)
