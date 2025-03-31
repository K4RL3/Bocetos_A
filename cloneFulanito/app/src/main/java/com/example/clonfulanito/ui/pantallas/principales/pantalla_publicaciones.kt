package com.example.clonfulanito.ui.pantallas.principales

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clonfulanito.vistas_modelos.FulanitoVM

@Composable
fun PantallaDePublicacion(modifier: Modifier, vm_fulanito: FulanitoVM, navegar_siguiente: () -> Unit){
    val publicaciones_descargadas by vm_fulanito.publicaciones.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        vm_fulanito.descargar_todas_public()
    }

    Column(modifier = modifier) {
        if(publicaciones_descargadas.isEmpty()){
            Text("Aqui deberia colocar una barra de cargando")
        }
        else {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
                items(publicaciones_descargadas){ publicacion ->
                    Button(onClick = {
                        vm_fulanito.seleccionar_publicacion(publicacion.Id)
                    }, modifier = Modifier.fillParentMaxWidth(0.8f).padding(10.dp)) {

                        Text("Titulo: ${publicacion.title}")
                        // Text("${publicacion.body}")
                        // HorizontalDivider()
                    }

                }

            }
        }
    }


}