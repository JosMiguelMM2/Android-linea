package com.example.gestordevehiculos.Entity

import androidx.room.PrimaryKey

data class Coche (
    @PrimaryKey(autoGenerate = true) val Id: Int = 0,
    val Matricula: String,
    val Marca: String,
    val Modelo: String,
    val Caballos: Long,
    val PersonaId: Int
)