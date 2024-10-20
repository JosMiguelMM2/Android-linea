package com.example.parcibiblioteca.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "miembros")
data class Miembros(
    @PrimaryKey(autoGenerate = true) val miembro_id: Long = 0,
    val nombre: String,
    val apellido: String,
    val fecha_inscripcion: Date
)