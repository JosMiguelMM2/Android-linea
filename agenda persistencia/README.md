# Aplicación de Gestión de Contactos

Esta aplicación permite a los usuarios guardar, editar, eliminar y buscar contactos. Cada contacto tiene los siguientes atributos:

- **Nombre**: El primer nombre del contacto.
- **Apellido**: El apellido del contacto.
- **Teléfono**: El número de teléfono, que es la clave primaria.
- **Hobby**: Un pasatiempo o interés del contacto.

## Funcionalidades

- **Agregar Contacto**: Los usuarios pueden ingresar los detalles de un nuevo contacto a través de un formulario. Al enviar el formulario, el contacto se guarda en la base de datos.

- **Lista de Contactos**: La aplicación muestra una lista de todos los contactos almacenados. Los usuarios pueden ver todos los contactos en una interfaz de lista.

- **Buscar Contacto**: Se puede buscar un contacto por nombre. A medida que el usuario escribe en un campo de búsqueda, la lista de contactos se filtra automáticamente para mostrar solo los resultados que coinciden con la consulta.

- **Editar Contacto**: Los usuarios pueden seleccionar un contacto existente para editar sus detalles. Al confirmar los cambios, la información del contacto se actualiza en la base de datos.

- **Eliminar Contacto**: Cada contacto tiene un botón para eliminarlo. Al hacer clic en este botón, se solicita la confirmación y, si se confirma, el contacto se elimina de la base de datos.

## Estructura de la Aplicación

1. **Base de Datos**: Utiliza Room para gestionar una base de datos SQLite que almacena los contactos.
2. **Modelo de Datos**: Define un modelo `Contacto` que representa la estructura de un contacto en la base de datos.
3. **Interfaz de Usuario**: Utiliza Jetpack Compose para crear una interfaz de usuario moderna y responsiva.
4. **ViewModel**: Implementa un `ViewModel` que se encarga de la lógica de negocio y el manejo de datos entre la interfaz de usuario y la base de datos.
5. **Navegación**: Utiliza Navigation Component para manejar la navegación entre diferentes pantallas de la aplicación.

## Instalación

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Asegúrate de tener todas las dependencias necesarias.
4. Ejecuta la aplicación en un emulador o dispositivo Android.

## Requisitos

- Android Studio
- Dispositivo Android o emulador
- Conexión a Internet (para actualizaciones y dependencias)

## Tecnologías Utilizadas

- Kotlin
- Jetpack Compose
- Room
- ViewModel
- Navigation Component
