package com.example.parcibiblioteca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcibiblioteca.Entity.Miembros
import com.example.parcibiblioteca.Model.MiembrosViewModel
import com.example.parcibiblioteca.Model.MiembrosViewModelFactory
import com.example.parcibiblioteca.Repository.MiembrosRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiembrosListScreen(
    miembrosRepository: MiembrosRepository,
    viewModel: MiembrosViewModel = viewModel(factory = MiembrosViewModelFactory(miembrosRepository))
) {
    val miembros = viewModel.miembros
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            viewModel.loadMiembros()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Miembros") },
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
                if (miembros.value.isEmpty()) {
                    Text(
                        text = "No hay miembros disponibles",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(miembros.value) { miembro ->
                            MiembroItem(miembro)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun MiembroItem(miembro: Miembros) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = miembro.nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${miembro.nombre} ${miembro.apellido} - Inscrito el: ${miembro.fecha_inscripcion}",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}