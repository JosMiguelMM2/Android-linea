package com.example.plantilla.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantilla.data.Contacto
import com.example.plantilla.model.ModelContacto
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContactScreen(
    navController: NavController,
    contactoViewModel: ModelContacto,
    contact: Contacto
) {
    println("_______________________________________________________")
    var nombre by remember { mutableStateOf(contact.nombre) }
    var apellido by remember { mutableStateOf(contact.apellido) }
    var telefono by remember { mutableStateOf(contact.telefono) }
    var hobby by remember { mutableStateOf(contact.hobby) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar contacto") }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate("contactList")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Contactos", fontSize = 18.sp)
                }
                TextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = apellido,
                    onValueChange = { apellido = it },
                    label = { Text("Apellido") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = telefono,
                    onValueChange = { telefono = it },
                    label = { Text("Teléfono") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = hobby,
                    onValueChange = { hobby = it },
                    label = { Text("Hobby") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        val updatedContact = Contacto(nombre, apellido, telefono, hobby)
                        scope.launch {
                            try {
                                contactoViewModel.update(updatedContact)
                                navController.navigate("contactList")
                            } catch (e: Exception) {
                                println("Ha ocurrido un error: ${e.message}")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Guardar", fontSize = 18.sp)
                }
            }
        }
    )
}