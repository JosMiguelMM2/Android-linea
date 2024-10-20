package com.example.parcibiblioteca.Entity

import androidx.room.Embedded
import androidx.room.Relation

data class AutoresConLibros(
    @Embedded val autor: Autores,
    @Relation(
        parentColumn = "autor_id",
        entityColumn = "autor_id"
    )
    val libros: List<Libros>
)