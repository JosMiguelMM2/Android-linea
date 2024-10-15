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
import com.example.gestordevehiculos.Entity.Persona
import com.example.gestordevehiculos.Model.PersonaModel
import kotlinx.coroutines.launch

@Composable
fun PersonaCreateView(
    navController: NavController,
    personaModel: PersonaModel
) {
    val nombre = remember { mutableStateOf("") }
    val apellido = remember { mutableStateOf("") }
    val apellido2 = remember { mutableStateOf("") }
    val dni = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = apellido.value,
            onValueChange = { apellido.value = it },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = apellido2.value,
            onValueChange = { apellido2.value = it },
            label = { Text("Segundo Apellido") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = dni.value,
            onValueChange = { dni.value = it },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                val persona = Persona(
                    Nombre = nombre.value,
                    Apellido = apellido.value,
                    Apellido2 = apellido2.value,
                    DNI = dni.value
                )
                scope.launch {
                    personaModel.insertPersona(persona)
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}