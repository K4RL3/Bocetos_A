package com.example.clon_fulanito.ui.pantallas.navegacion.controladores

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.clon_fulanito.R

//  colores temáticos
val EspacioFondo = Color(0xFF0D1B2A) // Azul oscuro
val EspacioPrimario = Color(0xFF1B263B) // Azul más claro
val EspacioSecundario = Color(0xFF415A77) // Gris azulado
val EspacioTexto = Color(0xFFE0E1DD) // Blanco grisáceo


sealed class PantallaMenuPrincipal(val ruta: String) {
    object Home : PantallaMenuPrincipal("pantalla_inicial")
    object StarWars : PantallaMenuPrincipal("pantalla_star_wars")
    object Perfil : PantallaMenuPrincipal("pantalla_perfil")
}

data class BotonesInferioresNavegacion(
    val etiqueta: String = "",
    val icono: ImageVector = Icons.Filled.Call,
    val ruta: String = "",
    val colorFondo: Color = EspacioFondo,
    val colorTexto: Color = EspacioTexto,
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