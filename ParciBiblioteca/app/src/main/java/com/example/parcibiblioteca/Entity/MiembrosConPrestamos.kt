package com.example.parcibiblioteca.Entity

import androidx.room.Embedded
import androidx.room.Relation

data class MiembrosConPrestamos(
    @Embedded val miembro: Miembros,
    @Relation(
        parentColumn = "miembro_id",
        entityColumn = "miembro_id"
    )
    val prestamos: List<Prestamos>
)
