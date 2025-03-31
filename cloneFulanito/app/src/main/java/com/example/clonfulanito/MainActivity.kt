package com.example.clonfulanito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clonfulanito.modelo.Publicacion
import com.example.clonfulanito.ui.navegacion.MenuPrinicpal
import com.example.clonfulanito.ui.navegacion.PantallaMenuPrincipal
import com.example.clonfulanito.ui.pantallas.PantallaNavegadora
import com.example.clonfulanito.ui.theme.ClonFulanitoTheme
import com.example.clonfulanito.vistas_modelos.FulanitoVM

class MainActivity : ComponentActivity() {
    private val modelo_app = FulanitoVM()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClonFulanitoTheme {
              MenuPrinicpal(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClonFulanitoTheme {
        MenuPrinicpal(modifier = Modifier.fillMaxSize())
    }
}