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
import com.example.gestordevehiculos.Model.PersonaModel
import com.example.gestordevehiculos.Model.PersonaViewModelFactory
import com.example.gestordevehiculos.Repository.PersonaRepository
import com.example.gestordevehiculos.screens.PersonaCreateView
import com.example.gestordevehiculos.ui.theme.GestorDeVehiculosTheme

class MainActivity : ComponentActivity() {
    private lateinit var personaDao: PersonaDao
    private lateinit var cocheDao: CocheDao

    private lateinit var personaRepository: PersonaRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = RPA.getDatabase(applicationContext)
        personaDao = db.personaDao()
        personaRepository = PersonaRepository(personaDao)

        val personaViewModel = ViewModelProvider(
            this,
            PersonaViewModelFactory(personaRepository)
        )[PersonaModel::class.java]

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