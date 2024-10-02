package com.example.plantilla.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacto::class], version = 1, exportSchema = false)
abstract class ContactosDatabase : RoomDatabase() {
    abstract fun contactoDao(): ContactoDao

    companion object {
        @Volatile
        private var INSTANCE: ContactosDatabase? = null

        fun getDatabase(context: Context): ContactosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactosDatabase::class.java,
                    "registro_contactos_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}