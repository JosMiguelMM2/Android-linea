package com.example.gestordevehiculos.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "coche",
    foreignKeys = [ForeignKey(
        entity = Persona::class,
        parentColumns = ["idPersona"],
        childColumns = ["idPersona"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Coche (
    @PrimaryKey(autoGenerate = true) val IdCoche: Int = 0,
    val Matricula: String,
    val Marca: String,
    val Modelo: String,
    val Caballos: Long,
    val idPersona: Int
)