package com.example.parcibiblioteca.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "prestamos")
data class Prestamos(
    @PrimaryKey(autoGenerate = true) val prestamo_id: Long = 0,
    val libro_id: Long,
    val miembro_id: Long,
    val fecha_prestamo: Date,
    val fecha_devolucion: Date?
)