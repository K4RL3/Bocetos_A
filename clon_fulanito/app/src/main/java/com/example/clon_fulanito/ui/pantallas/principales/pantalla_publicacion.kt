package com.example.clon_fulanito.ui.pantallas.principales

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clon_fulanito.ui.theme.*
import com.example.clon_fulanito.vista_moddelos.FulanitoViewModel

@Composable
fun PantallaDePublicacion(modifier: Modifier, vm_fulanito: FulanitoViewModel) {
    val comentarios by vm_fulanito.comentarios_de_publicacion.observeAsState(emptyList())
    val publicacion by vm_fulanito.publicacion_seleccionada.observeAsState(null)

    if (publicacion != null) {
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
            // Título de la publicación
            Text(
                text = "${publicacion!!.title}",
                color = DoradoGalactico, // Dorado brillante
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                ),
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Cuerpo de la publicación
            Text(
                text = publicacion!!.body,
                color = GrisMetalico, // Gris metálico
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Subtítulo de comentarios
            Text(
                text = "Comentarios:",
                color = PlateadoGalactico, // Plateado brillante
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                items(comentarios) { comentario ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        // Título del comentario
                        Text(
                            text = "${comentario.name}",
                            color = TatooineArena, // Dorado brillante
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                        // Cuerpo del comentario
                        Text(
                            text = comentario.body,
                            color = GrisMetalico, // Gris metálico
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Divisor
                        HorizontalDivider(
                            color = GrisOscuro, // Gris oscuro
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}