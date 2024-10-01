package com.example.plantilla.Database

import android.app.Application
import androidx.room.Room

class UserDatabase:Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "app-database"
        ).build()
    }
}