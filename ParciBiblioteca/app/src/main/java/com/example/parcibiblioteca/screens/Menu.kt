package com.example.parcibiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController) {
    val colors = MaterialTheme.colorScheme
    ParciBibliotecaTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text("Biblioteca", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colors.primary, titleContentColor = colors.onPrimary
                )
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuButton("Autores", "Autores", navController = navController)
                MenuButton("Libros", "Libros", navController = navController)
                MenuButton("Préstamos", "Préstamos", navController = navController)
                MenuButton("Miembros", "Miembros", navController = navController)
            }
        })
    }
}

@Composable
fun MenuButton(text: String, pantalla: String, navController: NavHostController) {
    val colors = MaterialTheme.colorScheme
    Button(
        onClick = {
            navController.navigate(pantalla)
        },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.secondary, contentColor = colors.onPrimary
        ),
        modifier = Modifier.fillMaxWidth().height(56.dp)
    ) {
        Text(text, fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}