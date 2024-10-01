package com.example.plantilla.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavBackStackEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContactScreen(
    contactViewModel: ContactViewModel = viewModel(),
    navController: NavController,
    backStackEntry: NavBackStackEntry
) {
    val contactName = backStackEntry.arguments?.getString("contactName") ?: return
    val contact = contactViewModel.contactList.find { it.nombre == contactName } ?: return

    var nombre by remember { mutableStateOf(contact.nombre) }
    var apellido by remember { mutableStateOf(contact.apellido) }
    var telefono by remember { mutableStateOf(contact.telefono) }
    var hobby by remember { mutableStateOf(contact.hobby) }

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
                        val updatedContact = Contact(
                            nombre = nombre,
                            apellido = apellido,
                            telefono = telefono,
                            hobby = hobby
                        )
                        contactViewModel.updateContact(contact, updatedContact)
                        navController.navigate("contactList")
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