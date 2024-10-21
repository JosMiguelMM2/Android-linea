package com.example.gestordevehiculos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestordevehiculos.Dao.CocheDao
import com.example.gestordevehiculos.Dao.PersonaDao
import com.example.gestordevehiculos.Database.RPA
import com.example.gestordevehiculos.Model.CocheModel
import com.example.gestordevehiculos.Model.CocheModelFactory
import com.example.gestordevehiculos.Model.PersonaModel
import com.example.gestordevehiculos.Model.PersonaViewModelFactory
import com.example.gestordevehiculos.Repository.CocheRepository
import com.example.gestordevehiculos.Repository.PersonaRepository
import com.example.gestordevehiculos.screens.CocheCreateView
import com.example.gestordevehiculos.screens.PersonaCreateView
import com.example.gestordevehiculos.ui.theme.GestorDeVehiculosTheme

class MainActivity : ComponentActivity() {
    // LOS DAO
    private lateinit var personaDao: PersonaDao
    private lateinit var cocheDao: CocheDao

    //Los Repositorios
    private lateinit var personaRepository: PersonaRepository
    private lateinit var cocheRepository: CocheRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = RPA.getDatabase(applicationContext)
        personaDao = db.personaDao()
        personaRepository = PersonaRepository(personaDao)

        cocheDao = db.cocheDao()
        cocheRepository = CocheRepository(cocheDao)
        val personaViewModel = ViewModelProvider(
            this,
            PersonaViewModelFactory(personaRepository)
        )[PersonaModel::class.java]

        val cocheViewModel = ViewModelProvider(
            this,
            CocheModelFactory(cocheRepository)
        )[CocheModel::class.java]

        enableEdgeToEdge()
        setContent {
            GestorDeVehiculosTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "PersonaCreate",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("PersonaCreate") {
                            PersonaCreateView(navController = navController,
                                personaModel=personaViewModel)
                        }
                        composable("CocheCreate") {
                            CocheCreateView(
                                navController = navController,
                                cocheModel = cocheViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GestorDeVehiculosTheme {
        Greeting("Android")
    }
}*/