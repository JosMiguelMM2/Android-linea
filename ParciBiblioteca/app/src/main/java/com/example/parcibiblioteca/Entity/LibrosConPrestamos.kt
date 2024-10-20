package com.example.parcibiblioteca.Entity

import androidx.room.Embedded
import androidx.room.Relation


data class LibrosConPrestamos(
    @Embedded val libro: Libros,
    @Relation(
        parentColumn = "libro_id",
        entityColumn = "libro_id"
    )
    val prestamos: List<Prestamos>
)
