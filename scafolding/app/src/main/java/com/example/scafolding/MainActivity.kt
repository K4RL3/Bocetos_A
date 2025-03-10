package com.example.scafolding

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scafolding.ui.theme.ScafoldingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScafoldingTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevista(){
    Aplicacion(modifier = Modifier.fillMaxSize())
}
@Composable
fun Aplicacion(modifier: Modifier){
    fun pulsaCarro(){
        Log.v("Aplicacion", "se pico el carro lol")
    }

    Scaffold(modifier = modifier,
        topBar = {
            BarraSuperior()
        },
        bottomBar = {
            BarraInferior()
        } ,
        floatingActionButton = {
            botonFlotante(al_push_picar = {
                pulsaCarro()
            })
        }
    )
    { pading_interior ->
        Column(modifier = Modifier.padding(pading_interior).background(Color.Cyan).fillMaxSize()) {
            Text("msj del otro mundo",
                modifier = Modifier
                    .fillMaxHeight(0.1f)
                    .background(color = Color.Blue))
        }
        Greeting("es la columna")
        Greeting("es la columna")
        Greeting("es la columna")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(){
    TopAppBar(colors = TopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
    ),
        title = {
        Text("titulo de la barra", modifier = Modifier)
    })
}

@Composable
fun BarraInferior(){
    fun btn_Puls(){
        Log.v("Aplicacion", "se pulso el brum")
    }

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("una opcion")
            Spacer(modifier = Modifier.width(15.dp))
            Icon(Icons.Rounded.ShoppingCart, contentDescription = "carrito brrum")
            botonFlotante(al_push_picar = {btn_Puls()})
        }

    }
}

@Composable
fun botonFlotante(al_push_picar: () -> Unit){
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Rounded.ShoppingCart, contentDescription = "")
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}