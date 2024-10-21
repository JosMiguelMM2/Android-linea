package com.example.gestordevehiculos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestordevehiculos.Entity.Coche
import com.example.gestordevehiculos.Entity.Persona
import com.example.gestordevehiculos.Model.CocheModel
import kotlinx.coroutines.launch

@Composable
fun CocheCreateView(
    navController: NavController,
    cocheModel: CocheModel
) {
    val matricula = remember { mutableStateOf("") }
    val marca = remember { mutableStateOf("") }
    val modelo = remember { mutableStateOf("") }
    val caballos = remember { mutableStateOf("") }
    val idPersona = remember { mutableStateOf("") }
    val expanded= remember { mutableStateOf(false) }
    val selectedPersona= remember { mutableStateOf<Persona?>(null) }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = matricula.value,
            onValueChange = { matricula.value = it },
            label = { Text("Matrícula") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = marca.value,
            onValueChange = { marca.value = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = modelo.value,
            onValueChange = { modelo.value = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = caballos.value,
            onValueChange = { caballos.value = it },
            label = { Text("Caballos") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = idPersona.value,
            onValueChange = { idPersona.value = it },
            label = { Text("ID Persona") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                val coche = Coche(
                    Matricula = matricula.value,
                    Marca = marca.value,
                    Modelo = modelo.value,
                    Caballos = caballos.value.toLongOrNull() ?: 0L,
                    idPersona = idPersona.value.toIntOrNull() ?: 0
                )
                scope.launch {
                    cocheModel.insertCoche(coche)
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}