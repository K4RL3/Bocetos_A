package com.example.clon_fulanito.ui.pantallas.principales

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.clon_fulanito.ui.theme.*
import com.example.clon_fulanito.vista_moddelos.FulanitoViewModel

@Composable
fun PantallaDePublicaciones(modifier: Modifier, vm_fulanito: FulanitoViewModel, navegar_siguiente: () -> Unit) {
    val publicaciones_descargadas by vm_fulanito.publicaciones.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        vm_fulanito.descargar_todas_las_publicaciones()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        FondoEstelar, // Negro absoluto
                        EspacioOscuro, // Azul oscuro profundo
                        EspacioPúrpura // Púrpura oscuro
                    )
                )
            )
            .padding(16.dp)
    ) {
        if (publicaciones_descargadas.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = SableLuzAzul, // Azul brillante
                    strokeWidth = 4.dp
                )
                Text(
                    "Cargando publicaciones...",
                    color = EstrellaBrillante,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        } else {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize()
            ) {
                items(publicaciones_descargadas) { publicacion ->
                    Column(
                        modifier = Modifier
                            .clickable {
                                vm_fulanito.seleccionar_publicacion(publicacion.id)
                                navegar_siguiente()
                            }
                            .padding(15.dp)
                            .background(color = EspacioClaro) // Gris azulado
                            .padding(10.dp)
                    ) {
                        Text(
                            "Título: ${publicacion.title}",
                            color = SableLuzAzul, // Azul brillante
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "Publicación: ${publicacion.body}",
                            color = NebulosaRosa, // Rosa brillante
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalDivider(color = GrisMetalico) // Gris metálico
                    }
                }
            }
        }
    }
}