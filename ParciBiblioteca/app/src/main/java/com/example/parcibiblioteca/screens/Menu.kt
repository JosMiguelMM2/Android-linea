package com.example.parcibiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen() {
    ParciBibliotecaTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Biblioteca", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF6200EE),
                        titleContentColor = Color.White
                    )
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MenuButton("Autores","Autores")
                    MenuButton("Libros", "Libros")
                    MenuButton("Préstamos","Préstamos")
                    MenuButton("Miembros", "Miembros")
                }
            }
        )
    }
}

@Composable
fun MenuButton(text: String, pantalla: String) {
    Button(
        onClick = { /* TODO: Handle button click */ },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6200EE),
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(text, fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}