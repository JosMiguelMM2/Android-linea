package com.example.parcibiblioteca.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.example.parcibiblioteca.Entity.Autores
import com.example.parcibiblioteca.Entity.Libros
import com.example.parcibiblioteca.Repository.AutoresRepository
import com.example.parcibiblioteca.Repository.LibrosRepository
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibrosCreateScreen(
    navController: NavHostController,
    librosRepository: LibrosRepository,
    autoresRepository: AutoresRepository
) {
    var titulo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var autores by remember { mutableStateOf(listOf<Autores>()) }
    var selectedAutor by remember { mutableStateOf<Autores?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val colors = MaterialTheme.colorScheme
    val scope = rememberCoroutineScope()

    // Cargar los autores en el rememberCoroutineScope
    LaunchedEffect(Unit) {
        autores = autoresRepository.getAllAutores()
    }

    ParciBibliotecaTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Libros", fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
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
                        value = titulo,
                        onValueChange = { titulo = it },
                        label = { Text("Título") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colors.primary,
                            unfocusedBorderColor = colors.onSurface
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = genero,
                        onValueChange = { genero = it },
                        label = { Text("Género") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colors.primary,
                            unfocusedBorderColor = colors.onSurface
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Aquí reemplazamos el Dropdown con una implementación simple
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.TopStart)
                    ) {
                        Text(
                            text = selectedAutor?.let{"${it.nombre} ${it.apellido}"} ?: "Selecciona un autor",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable(onClick = { expanded = true })
                                .border(1.dp, colors.onSurface)
                                .padding(8.dp)
                        )

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            autores.forEach { autor ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedAutor = autor
                                        expanded = false
                                    },
                                    text = {
                                        Text(text = "Autor: ${autor.nombre} ${autor.apellido} (${autor.nacionalidad})")
                                    }
                                )
                            }
                        }
                    }

                    Button(
                        onClick = {
                            if (titulo.isNotEmpty() && genero.isNotEmpty() && selectedAutor != null) {
                                val nuevoLibro = Libros(
                                    titulo = titulo,
                                    genero = genero,
                                    autor_id = selectedAutor!!.autor_id
                                )
                                scope.launch {
                                    librosRepository.insertLibros(nuevoLibro)
                                    navController.popBackStack()
                                }
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colors.secondary,
                            contentColor = colors.onPrimary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(
                            "Guardar", fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        )
    }
}
