package com.example.gestordevehiculos.Repository

import com.example.gestordevehiculos.Dao.CocheDao
import com.example.gestordevehiculos.Entity.Coche


class CocheRepository (private val cocheDao: CocheDao){
    suspend fun insertCoche(coche: Coche) = cocheDao.insertCoche(coche)

    suspend fun getAllCoches() = cocheDao.getAllCoches()

    suspend fun getCocheById(id: Int) = cocheDao.getCocheById(id)

    suspend fun updateCoche(coche: Coche) = cocheDao.updateCoche(coche)

    suspend fun deleteCoche(coche: Coche) = cocheDao.deleteCoche(coche)

    suspend fun getCocheWithPersonaDetails() = cocheDao.getCocheWithPersonaDetails()
}