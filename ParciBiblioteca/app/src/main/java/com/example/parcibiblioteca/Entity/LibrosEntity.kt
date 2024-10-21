package com.example.parcibiblioteca.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "libros",
    foreignKeys = [ForeignKey(
        entity = Autores::class,
        parentColumns = ["autor_id"],
        childColumns = ["autor_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Libros(
    @PrimaryKey(autoGenerate = true) val libro_id: Long = 0,
    val titulo: String,
    val genero: String,
    val autor_id: Long
)