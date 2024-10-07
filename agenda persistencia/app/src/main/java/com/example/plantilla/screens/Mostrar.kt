package com.example.plantilla.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantilla.data.Contacto
import com.example.plantilla.model.ModelContacto


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    navController: NavController,
    contactoModal: ModelContacto
) {
    var searchText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        contactoModal.getAllContacts()
    }
    val contactos = contactoModal.contactos.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Contactos") }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                BasicTextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        contactoModal.search(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(color = Color.White),
                    decorationBox = { innerTextField ->
                        if (searchText.isEmpty()) {
                            Text("Buscar...", style = MaterialTheme.typography.bodyLarge)
                        }
                        innerTextField()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navController.navigate("contactForm")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Registrar", fontSize = 18.sp)
                }
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(contactos) { contacto ->
                        ContactItem(contact = contacto, navController = navController, contactoModal = contactoModal)
                    }

                }

            }
        }
    )
}

@Composable
fun ContactItem(
    contact: Contacto, // Changed to a single Contacto object
    navController: NavController,
    contactoModal: ModelContacto
) {
    // Each contact is displayed in a card
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "${contact.nombre} ${contact.apellido}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Teléfono: ${contact.telefono}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Hobby: ${contact.hobby}", style = MaterialTheme.typography.bodyMedium)
        }
        Row {
            Button(
                onClick = {
                    contactoModal.delete(contact)
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Eliminar")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(

                onClick = {
                    navController.navigate("editContact/${contact.telefono}") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Editar")
            }
        }
    }
}