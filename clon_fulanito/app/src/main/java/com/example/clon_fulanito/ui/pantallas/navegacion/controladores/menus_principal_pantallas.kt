package com.example.clon_fulanito.ui.pantallas.navegacion.controladores

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.clon_fulanito.R


sealed class PantallaMenuPrincipal(val ruta: String) {
    object Home : PantallaMenuPrincipal("pantalla_inicial")
    object StarWars : PantallaMenuPrincipal("pantalla_star_wars")
    object Perfil : PantallaMenuPrincipal("pantalla_perfil")
}

data class BotonesInferioresNavegacion(
    val etiqueta: String = "",
    val icono: ImageVector = Icons.Filled.Call,
    val ruta: String = "",
    val colorIcono: Color = Color.Black, // Íconos negros
) {
    fun botones_de_navegacion(): List<BotonesInferioresNavegacion> {
        return listOf(
            BotonesInferioresNavegacion(
                etiqueta = "Home",
                icono = Icons.Filled.Home,
                ruta = PantallaMenuPrincipal.Home.ruta
            ),
            BotonesInferioresNavegacion(
                etiqueta = "Star Wars",
                icono = Icons.Filled.Info,
                ruta = PantallaMenuPrincipal.StarWars.ruta
            ),
            BotonesInferioresNavegacion(
                etiqueta = "Perfil",
                icono = Icons.Filled.AccountCircle,
                ruta = PantallaMenuPrincipal.Perfil.ruta
            )
        )
    }
}