package com.example.clon_fulanito.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clon_fulanito.ui.theme.*

@Composable
fun PantallaPerfil(modifier: Modifier = Modifier) {
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
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Centrado en la parte superior
    ) {
        // Icono de perfil
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Icono de perfil",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 16.dp),
            tint = DoradoGalactico // Dorado brillante
        )

        // Nombre de usuario
        Text(
            text = "Usuario",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            color = EstrellaBrillante, // Blanco brillante
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        // Tarjeta de información de contacto
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(color = FondoEstelar.copy(alpha = 0.8f))
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Título de la tarjeta
                Text(
                    text = "Información de Contacto",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = DoradoGalactico // Plateado brillante
                )

                // Correo electrónico
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Correo Electrónico",
                        tint = DoradoGalactico // Azul brillante
                    )
                    Text(
                        text = "perfil_fulanito@gmail.com",
                        color = GrisMetalico, // Gris metálico
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Ubicación
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Ubicación",
                        tint = DoradoGalactico // Verde brillante
                    )
                    Text(
                        text = "Una galaxia muy, muy lejana",
                        color = GrisMetalico, // Gris metálico
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}