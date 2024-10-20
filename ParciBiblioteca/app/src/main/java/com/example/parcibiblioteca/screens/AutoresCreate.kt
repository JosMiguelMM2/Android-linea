package com.example.parcibiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoresCreateScreen(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }
    val colors = MaterialTheme.colorScheme

    ParciBibliotecaTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Autores", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colors.primary,
                        titleContentColor = colors.onPrimary
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
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colors.primary,
                            unfocusedBorderColor = colors.onSurface
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = apellido,
                        onValueChange = { apellido = it },
                        label = { Text("Apellido") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colors.primary,
                            unfocusedBorderColor = colors.onSurface
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = nacionalidad,
                        onValueChange = { nacionalidad = it },
                        label = { Text("Nacionalidad") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colors.primary,
                            unfocusedBorderColor = colors.onSurface
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = { /* TODO: Handle save action */ },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colors.secondary,
                            contentColor = colors.onPrimary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text("Guardar", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        )
    }
}