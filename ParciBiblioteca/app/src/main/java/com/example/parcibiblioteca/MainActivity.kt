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
import com.example.parcibiblioteca.Dao.*
import com.example.parcibiblioteca.Database.BibliotecaDatabase
import com.example.parcibiblioteca.Repository.*
import com.example.parcibiblioteca.screens.*
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme

class MainActivity : ComponentActivity() {

    // DAO
    private lateinit var autoresDao: AutoresDao
    private lateinit var miembrosDao: MiembrosDao
    private lateinit var librosDao: LibrosDao
    private lateinit var prestamosDao: PrestamosDao
    private lateinit var autoresConLibrosDao: AutoresConLibrosDao

    // Repositorios
    private lateinit var autoresRepository: AutoresRepository
    private lateinit var miembrosRepository: MiembrosRepository
    private lateinit var librosRepository: LibrosRepository
    private lateinit var prestamosRepository: PrestamosRepository
    private lateinit var autoresConLibrosRepository: AutoresConLibrosRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = BibliotecaDatabase.getDatabase(applicationContext)

        autoresDao = db.AutoresDao()
        autoresRepository = AutoresRepository(autoresDao)

        miembrosDao = db.MiembrosDao()
        miembrosRepository = MiembrosRepository(miembrosDao)

        librosDao = db.LibrosDao()
        librosRepository = LibrosRepository(librosDao)

        prestamosDao = db.PrestamosDao()
        prestamosRepository = PrestamosRepository(prestamosDao)

        autoresConLibrosDao = db.AutoresConLibrosDao()
        autoresConLibrosRepository = AutoresConLibrosRepository(autoresConLibrosDao)
        // Modelos

        enableEdgeToEdge()
        setContent {
            ParciBibliotecaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    navegationApp(
                        autoresRepository = autoresRepository,
                        miembrosRepository = miembrosRepository,
                        librosRepository = librosRepository,
                        prestamosRepository = prestamosRepository,
                        autoresConLibrosRepository = autoresConLibrosRepository
                    )
                }
            }
        }
    }
}

@Composable
fun navegationApp(
    autoresRepository: AutoresRepository,
    miembrosRepository: MiembrosRepository,
    librosRepository: LibrosRepository,
    prestamosRepository: PrestamosRepository,
    autoresConLibrosRepository: AutoresConLibrosRepository
) {
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
                navController = navController,
                autoresRepository = autoresRepository
            )
        }

        composable("Miembros") {
            MiembrosCreateScreen(
                navController = navController,
                miembrosRepository = miembrosRepository
            )
        }

        composable("Libros") {
            LibrosCreateScreen(
                navController = navController,
                librosRepository = librosRepository,
                autoresRepository = autoresRepository
            )
        }

        composable("Prestamos") {
            PrestamosCreateScreen(
                navController = navController,
                prestamosRepository = prestamosRepository,
                miembrosRepository = miembrosRepository,
                librosRepository = librosRepository
            )
        }
        composable("AutoresList") {
            AutoresListScreen(
                autoresRepository = autoresRepository
            )
        }

        composable("MiembrosList") {
            MiembrosListScreen(
                miembrosRepository = miembrosRepository
            )
        }

        composable("LibrosList") {
            LibrosListScreen(
                autoresConLibrosRepository = autoresConLibrosRepository
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