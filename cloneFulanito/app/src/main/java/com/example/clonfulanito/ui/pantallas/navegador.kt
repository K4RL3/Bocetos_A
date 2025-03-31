package com.example.clonfulanito.ui.pantallas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clonfulanito.ui.pantallas.principales.PantallaDePublicacion
import com.example.clonfulanito.vistas_modelos.FulanitoVM

@Composable
fun PantallaNavegadora(modifier: Modifier, vm_fulanito: FulanitoVM){
    val control_de_navegacion = rememberNavController()

    NavHost(navController = control_de_navegacion, startDestination = PantallaPublicaciones){
        composable<PantallaPublicaciones> {
            PantallaDePublicacion(modifier, vm_fulanito){

            }
        }

        composable<PantallaPublicacion> {  }

        composable<PantallaPerfil> {  }
    }
}