package com.example.parcibiblioteca.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = NeonBlue80,
    secondary = Teal80,
    tertiary = NeonGreen80,
    onPrimary = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = NeonBlue40,
    secondary = Teal40,
    tertiary = NeonGreen40,
    onPrimary = Color.Black,

    /* Otros colores predeterminados para sobreescribir
    background = Color(0xFF121212),  // Fondo oscuro
    surface = Color(0xFF1D1D1D),     // Superficie más clara
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFFE0E0E0), // Texto sobre fondo oscuro
    onSurface = Color(0xFFE0E0E0),    // Texto sobre superficie
    */
)

@Composable
fun ParciBibliotecaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}