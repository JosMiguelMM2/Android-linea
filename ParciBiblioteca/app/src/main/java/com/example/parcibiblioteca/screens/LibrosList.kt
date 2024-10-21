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
import com.example.parcibiblioteca.Entity.AutoresConLibros
import com.example.parcibiblioteca.Model.AutoresConLibrosModel
import com.example.parcibiblioteca.Model.AutoresConLibrosModelFactory
import com.example.parcibiblioteca.Repository.AutoresConLibrosRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibrosListScreen(
    autoresConLibrosRepository: AutoresConLibrosRepository,
    viewModel: AutoresConLibrosModel = viewModel(
        factory = AutoresConLibrosModelFactory(autoresConLibrosRepository)
    )
) {
    val librosConAutores by viewModel.autoresConLibros

    LaunchedEffect(Unit) {
        viewModel.fetchAutoresConLibros()
        println(librosConAutores)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Libros") },
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
                if (librosConAutores.isEmpty()) {
                    Text(
                        text = "No hay libros disponibles",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(librosConAutores) { autorConLibros ->
                            LibroItem(autorConLibros)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun LibroItem(autoresConLibros: AutoresConLibros) {
    println("ccc")
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
                text = "${autoresConLibros.autor.nombre} " +
                        "${autoresConLibros.autor.apellido} " +
                        "(${autoresConLibros.autor.nacionalidad})",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            autoresConLibros.libros.forEach { libro ->
                Text(
                    text = "Título: ${libro.titulo}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Género: ${libro.genero}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}