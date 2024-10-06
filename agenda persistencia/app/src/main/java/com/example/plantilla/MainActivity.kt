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
import com.example.plantilla.data.ContactoDao
import com.example.plantilla.data.ContactoRepository1
import com.example.plantilla.data.ContactosDatabase
import com.example.plantilla.screens.ContactFormScreen
import com.example.plantilla.ui.theme.PlantillaTheme

class MainActivity : ComponentActivity() {
    private lateinit var contactoDao: ContactoDao
    private lateinit var contactoRepository1: ContactoRepository1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = ContactosDatabase.getDatabase(applicationContext)
        contactoDao = db.contactoDao()
        contactoRepository1 = ContactoRepository1(contactoDao)
        enableEdgeToEdge()
        setContent {
            PlantillaTheme {
                // Setup de la UI principal
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "contactForm",
                        modifier = Modifier.padding(innerPadding) // El padding se aplica aquí
                    ) {
                        composable("contactForm") {
                            ContactFormScreen(
                                navController = navController,
                                userRepository1 = contactoRepository1
                            )
                        }
                        composable("contactList") {
                            //ContactListScreen(navController = navController, contactViewModel = contactViewModel)
                        }
                        composable("editContact/{contactName}") { backStackEntry ->
                            //EditContactScreen(contactViewModel, navController, backStackEntry)
                        }
                    }
                }
            }
        }
    }
}

