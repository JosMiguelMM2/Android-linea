package com.example.parcibiblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcibiblioteca.Database.BibliotecaDatabase
import com.example.parcibiblioteca.screens.*
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = BibliotecaDatabase.getDatabase(applicationContext)
        enableEdgeToEdge()
        setContent {
            ParciBibliotecaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    navegationApp()
                }
            }
        }
    }
}

@Composable
fun navegationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Menu"
    ) {
        composable("Menu") {
            MenuScreen(
                navController = navController
            )
        }

        composable("Autores") {
            AutoresCreateScreen(
                navController = navController
            )
        }

        composable("Miembros") {
            MiembrosCreateScreen(
                navController = navController
            )
        }

        composable("Libros") {
            LibrosCreateScreen(
                navController = navController
            )
        }

        composable("Prestamos") {
            PrestamosCreateScreen(
                navController = navController
            )
        }
    }

}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParciBibliotecaTheme {
        Greeting("Android")
    }
}*/