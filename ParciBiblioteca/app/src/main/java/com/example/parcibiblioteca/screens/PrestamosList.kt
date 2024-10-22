package com.example.parcibiblioteca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcibiblioteca.Model.LibrosConPrestamosModel
import com.example.parcibiblioteca.Model.LibrosConPrestamosModelFactory
import com.example.parcibiblioteca.Repository.LibrosConPrestamosRepository
import com.example.parcibiblioteca.Entity.LibrosConPrestamos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamosListScreen(
    librosConPrestamosRepository: LibrosConPrestamosRepository,
    viewModel: LibrosConPrestamosModel = viewModel(
        factory = LibrosConPrestamosModelFactory(librosConPrestamosRepository)
    )
) {
    val librosConPrestamos by viewModel.librosConPrestamos

    LaunchedEffect(Unit) {
        viewModel.fetchLibrosConPrestamos()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Prestamos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                if (librosConPrestamos.isEmpty()) {
                    Text(
                        text = "No hay prestamos disponibles",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(librosConPrestamos) { libroConPrestamos ->
                            PrestamoItem(libroConPrestamos)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun PrestamoItem(librosConPrestamos: LibrosConPrestamos) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Libro: ${librosConPrestamos.libro.titulo}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            librosConPrestamos.prestamos.forEach { prestamo ->
                Text(
                    text = "Fecha prestamo : ${prestamo.fecha_prestamo}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Fecha devolución : ${prestamo.fecha_devolucion}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}