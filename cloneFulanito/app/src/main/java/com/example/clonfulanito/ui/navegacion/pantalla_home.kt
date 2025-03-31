package com.example.clonfulanito.ui.navegacion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clonfulanito.ui.pantallas.PantallaNavegadora
import com.example.clonfulanito.vistas_modelos.FulanitoVM



@Composable
fun  MenuPrinicpal(modifier: Modifier){
    val control_nav = rememberNavController()

    Scaffold (modifier = modifier, bottomBar = {
        NavigationBar {
            Text("holamundo", modifier = Modifier.clickable{
                control_nav.navigate(PantallaMenuPrincipal.Home.ruta){
                    popUpTo(control_nav.graph.startDestinationId){
                        saveState= true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
            Text("swapi", modifier = Modifier.clickable{
                control_nav.navigate(PantallaMenuPrincipal.Starwars.ruta){
                    popUpTo(control_nav.graph.startDestinationId){
                        saveState= true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
            Text("perfiñ", modifier = Modifier.clickable{
                control_nav.navigate(PantallaMenuPrincipal.Perfil.ruta){
                    popUpTo(control_nav.graph.startDestinationId){
                        saveState= true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
    }) {innerPaddin ->
        NavHost(navController = control_nav,
            startDestination = PantallaMenuPrincipal.Home.ruta,
            modifier = Modifier.padding(innerPaddin)){

            composable(PantallaMenuPrincipal.Home.ruta){
                PantallaNavegadora(modifier = Modifier.fillMaxSize(), vm_fulanito = FulanitoVM())
            }

            composable(PantallaMenuPrincipal.Starwars.ruta) {
                Text("Pantalla b o starwars")
            }

            composable(PantallaMenuPrincipal.Perfil.ruta) {
                Text("pantalla c o de perfil")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevista(){
    MenuPrinicpal(Modifier.fillMaxSize())
}