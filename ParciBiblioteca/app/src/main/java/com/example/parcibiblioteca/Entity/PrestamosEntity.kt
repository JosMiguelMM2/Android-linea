package com.example.parcibiblioteca.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.util.Date


@Entity(
    tableName = "prestamos",
    foreignKeys = [
        ForeignKey(
            entity = Libros::class,
            parentColumns = ["libro_id"],
            childColumns = ["libro_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Miembros::class,
            parentColumns = ["miembro_id"],
            childColumns = ["miembro_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Prestamos(
    @PrimaryKey(autoGenerate = true) val prestamo_id: Long = 0,
    val libro_id: Long,
    val miembro_id: Long,
    val fecha_prestamo: Date,
    val fecha_devolucion: Date?
)