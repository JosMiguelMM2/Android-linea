package com.example.plantilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantilla.screens.ContactFormScreen
import com.example.plantilla.screens.ContactListScreen
import com.example.plantilla.ui.theme.PlantillaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantillaTheme {
                // Setup de la UI principal
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // Aseguramos que el NavHost respete el padding
                    NavHost(
                        navController = navController,
                        startDestination = "contactForm",
                        modifier = Modifier.padding(innerPadding) // El padding se aplica aquí
                    ) {
                        composable("contactForm") {
                            ContactFormScreen(navController = navController)
                        }
                        composable("contactList") {
                            ContactListScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

