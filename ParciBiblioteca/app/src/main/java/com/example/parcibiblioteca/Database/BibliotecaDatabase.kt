package com.example.parcibiblioteca.Database

import android.content.Context
import androidx.room.*
import com.example.parcibiblioteca.Dao.*
import com.example.parcibiblioteca.Entity.Autores
import com.example.parcibiblioteca.Entity.Libros
import com.example.parcibiblioteca.Entity.Miembros
import com.example.parcibiblioteca.Entity.Prestamos
import com.example.parcibiblioteca.Funciones.ConvertersDate

@Database(
    entities = [
        Autores::class,
        Libros::class,
        Miembros::class,
        Prestamos::class,
    ], version = 1, exportSchema = false
)
@TypeConverters(ConvertersDate::class)
abstract class BibliotecaDatabase: RoomDatabase() {

    abstract fun AutoresDao(): AutoresDao
    abstract fun LibrosDao(): LibrosDao
    abstract fun PrestamosDao(): PrestamosDao
    abstract fun MiembrosDao(): MiembrosDao
    abstract fun AutoresConLibrosDao(): AutoresConLibrosDao
    abstract fun LibrosConPrestamosDao(): LibrosConPrestamosDao
    abstract fun MiembrosConPrestamosDao(): MiembrosConPrestamosDao

    companion object{
        @Volatile
        private var INSTANCE: BibliotecaDatabase? = null

        fun getDatabase(context: Context): BibliotecaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BibliotecaDatabase::class.java,
                    "biblioteca"
                )
                    //.fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}