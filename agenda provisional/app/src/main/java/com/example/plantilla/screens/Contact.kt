package com.example.plantilla.screens
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

data class Contact(
    val nombre: String,
    val apellido: String,
    val telefono: String,
    val hobby: String
)

class ContactViewModel : ViewModel() {
    val contactList = mutableStateListOf<Contact>()

    fun addContact(contact: Contact) {
        contactList.add(contact)
    }

    fun removeContact(contact: Contact) {
        contactList.remove(contact)
    }

    fun updateContact(oldContact: Contact, newContact: Contact) {
        val index = contactList.indexOf(oldContact)
        if (index != -1) {
            contactList[index] = newContact
        }
    }
}