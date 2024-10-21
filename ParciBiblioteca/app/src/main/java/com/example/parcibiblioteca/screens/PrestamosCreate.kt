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
import com.example.parcibiblioteca.Entity.Libros
import com.example.parcibiblioteca.Entity.Miembros
import com.example.parcibiblioteca.Entity.Prestamos
import com.example.parcibiblioteca.Repository.LibrosRepository
import com.example.parcibiblioteca.Repository.MiembrosRepository
import com.example.parcibiblioteca.Repository.PrestamosRepository
import com.example.parcibiblioteca.ui.theme.ParciBibliotecaTheme
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamosCreateScreen(
    navController: NavHostController,
    prestamosRepository: PrestamosRepository,
    miembrosRepository: MiembrosRepository,
    librosRepository: LibrosRepository
) {
    var fechaPrestamo by remember { mutableStateOf("") }
    var fechaDevolucion by remember { mutableStateOf("") }
    val colors = MaterialTheme.colorScheme
    var libros by remember { mutableStateOf(listOf<Libros>()) }
    var selectedLibro by remember { mutableStateOf<Libros?>(null) }
    var expandedlibros by remember { mutableStateOf(false) }
    var miembros by remember { mutableStateOf(listOf<Miembros>()) }
    var selectedMiembros by remember { mutableStateOf<Miembros?>(null) }
    var expandedMiembros by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        libros = librosRepository.getAllLibros()
        miembros = miembrosRepository.getAllMiembros()
    }
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

                    // Aquí reemplazamos el Dropdown con una implementación simple
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.TopStart)
                    ) {
                        Text(
                            text = selectedLibro?.let { "${it.titulo} ${it.genero}" } ?: "Selecciona un libro",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable(onClick = { expandedlibros = true })
                                .border(1.dp, colors.onSurface)
                                .padding(8.dp)
                        )

                        DropdownMenu(
                            expanded = expandedlibros,
                            onDismissRequest = { expandedlibros = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            libros.forEach { libro ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedLibro = libro
                                        expandedlibros = false
                                    },
                                    text = {
                                        Text(text = "Libro: ${libro.titulo} ${libro.genero}")
                                    }
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.TopStart)
                    ) {
                        Text(
                            text = selectedMiembros?.let { "${it.nombre} ${it.apellido} " } ?: "Selecciona un miembro",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable(onClick = { expandedMiembros = true })
                                .border(1.dp, colors.onSurface)
                                .padding(8.dp)
                        )

                        DropdownMenu(
                            expanded = expandedMiembros,
                            onDismissRequest = { expandedMiembros = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            miembros.forEach { miembro ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedMiembros = miembro
                                        expandedMiembros = false
                                    },
                                    text = {
                                        Text(text = "Miembro: ${miembro.nombre} ${miembro.apellido}")
                                    }
                                )
                            }
                        }
                    }
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
                        onClick = {
                            if (selectedLibro != null && selectedMiembros != null && fechaPrestamo.isNotEmpty()) {
                                val dateFormat = SimpleDateFormat("yyyy-MM-dd")
                                val fechaPrestamoDate: Date = dateFormat.parse(fechaPrestamo)
                                val fechaDevolucionDate: Date? = if (fechaDevolucion.isNotEmpty())
                                    dateFormat.parse(fechaDevolucion) else null
                                val nuevoPrestamo = Prestamos(
                                    libro_id = selectedLibro!!.libro_id,
                                    miembro_id = selectedMiembros!!.miembro_id,
                                    fecha_prestamo = fechaPrestamoDate,
                                    fecha_devolucion = fechaDevolucionDate
                                )
                                scope.launch {
                                    prestamosRepository.insertPrestamos(nuevoPrestamo)
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
                        Text("Guardar", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        )
    }
}