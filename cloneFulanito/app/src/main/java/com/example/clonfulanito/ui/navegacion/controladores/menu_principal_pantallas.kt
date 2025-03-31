package com.example.clonfulanito.ui.navegacion.controladores

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.ui.graphics.vector.ImageVector

sealed class PantallaMenuPrincipal(val ruta: String){
    object Home: PantallaMenuPrincipal("pantala inicial")
    object Starwars: PantallaMenuPrincipal("pantalla_star_wars")
    object Perfil: PantallaMenuPrincipal("pantalla_perfil")
}

data class BotonesinferioresNav(
    val etiqueta: String= "",
    val iconos: ImageVector = Icons.Filled.Call,
    val ruta: String =""
)
fun botones_nav(): List<BotonesinferioresNav>{
    return ListOf(
        BotonesinferioresNav(etiqueta = "Home", ruta = PantallaMenuPrincipal.Home.ruta)
    )
}