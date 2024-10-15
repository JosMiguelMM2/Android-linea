package com.example.gestordevehiculos.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gestordevehiculos.Dao.CocheDao
import com.example.gestordevehiculos.Dao.PersonaDao
import com.example.gestordevehiculos.Entity.Coche
import com.example.gestordevehiculos.Entity.Persona

@Database(entities = [Persona::class, Coche::class], version = 1, exportSchema = false)
abstract class RPA :RoomDatabase(){
    abstract fun personaDao(): PersonaDao
    abstract fun cocheDao(): CocheDao

    companion object{
        @Volatile
        private var INSTANCE: RPA? = null

        fun getDatabase(context: Context): RPA {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RPA::class.java,
                    "RPA"
                )
                    //.fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}