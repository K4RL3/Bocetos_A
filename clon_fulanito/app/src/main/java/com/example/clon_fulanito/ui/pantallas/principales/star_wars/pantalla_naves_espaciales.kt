package com.example.clon_fulanito.ui.pantallas.principales.star_wars

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.core.provider.FontsContractCompat.Columns
import com.example.clon_fulanito.vista_modelos.SWAPImodelo

@Composable
fun PantallaNavesEspaciales(modifier: Modifier){
   val vm_swapi = SWAPImodelo()

    val pagina_actual by vm_swapi.pagina_actual.observeAsState(null)

    LaunchedEffect(UInt) {
        vm_swapi.descargar_pag()
    }

    Column(modifier =modifier) {
        if (pagina_actual == null){
            Text("CARGADO")
        }
        else{
            Text("Resultados")

            LazyColumn {
                items(pagina_actual!!.results){nave_espacial ->
                    Text("Nave: ${nave_espacial.name}")
                    Text("Modelo: ${nave_espacial.model}")
                    HorizontalDivider()

                }
            }

            Row {
                Text("pagina Anterior",
                    modifier = Modifier.clickable {
                        vm_swapi.pasar_a_sig_pag()
                    }
                )
                Text("pagina Sigiente",
                    modifier = Modifier.clickable {
                        vm_swapi.pasar_a_ant_pag()
                    }
                )
            }
        }
    }
}