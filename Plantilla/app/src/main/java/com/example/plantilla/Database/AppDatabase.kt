package com.example.plantilla.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.plantilla.Entity.Contactos
import com.example.plantilla.Repository.RepositoryContacto

@Database(entities = [Contactos::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun contactDao(): RepositoryContacto
}
