package com.example.plantilla.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    navController: NavController,
    contactViewModel: ContactViewModel = viewModel()
) {
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
                Button(
                    onClick = {

                        navController.navigate("contactForm")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Registrar", fontSize = 18.sp)
                }
                // Verificamos si la lista de contactos está vacía
                if (contactViewModel.contactList.isEmpty()) {
                    Text("No hay contactos registrados.")
                    println("__________________________________ ${contactViewModel.contactList}")
                } else {
                    // LazyColumn para mostrar la lista de contactos
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // items toma la lista de contactos y los dibuja en la UI

                        items(contactViewModel.contactList) { contact ->
                            ContactItem(contact)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ContactItem(contact: Contact) {
    // Cada contacto se muestra en una tarjeta
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
    }
}
