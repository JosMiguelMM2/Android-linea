package com.example.parcibiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamosCreateScreen(navController: NavHostController) {
    var fechaPrestamo by remember { mutableStateOf("") }
    var fechaDevolucion by remember { mutableStateOf("") }
    val colors = MaterialTheme.colorScheme

    ParciBibliotecaTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Préstamos", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
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
                        value = fechaPrestamo,
                        onValueChange = { fechaPrestamo = it },
                        label = { Text("Fecha Préstamo") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colors.primary,
                            unfocusedBorderColor = colors.onSurface
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = fechaDevolucion,
                        onValueChange = { fechaDevolucion = it },
                        label = { Text("Fecha Devolución") },
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