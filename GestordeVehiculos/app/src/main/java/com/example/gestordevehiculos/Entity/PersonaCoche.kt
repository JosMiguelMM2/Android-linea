package com.example.gestordevehiculos.Entity

import androidx.room.Embedded
import androidx.room.Relation

data class PersonaConCoche(
    @Embedded val persona: Persona,
    /*@Relation(
        parentColumn = "idPersona",
        entityColumn = "idPersona"
    )
    val coche: Coche*/

    @Embedded val coche: Coche
)
