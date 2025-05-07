package com.example.mapas

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.mapas.ui.theme.MapasTheme
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapasTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background) {
                    vistaMapa()
                }
            }
        }
        val contexto = applicationContext
        Configuration.getInstance().load(contexto, PreferenceManager.getDefaultSharedPreferences(contexto))
        Configuration.getInstance().userAgentValue = "Mapa"
    }
}

@Composable
fun vistaMapa(){
    val contexto = LocalContext.current
    val map_view = MapView(contexto)

    map_view.setTileSource(TileSourceFactory.MAPNIK)

    map_view.setBuiltInZoomControls(true)
    map_view.setMultiTouchControls(true)

    map_view.controller.setZoom(18.0)

    AndroidView(modifier = Modifier.fillMaxSize(),
        factory = {contexto ->
            map_view
        }){ map_view ->

        val rodadora = Marker(map_view)
        val iada = Marker(map_view)
        rodadora.position = GeoPoint(31.690010694618078, -106.42748670330056)
        iada.position = GeoPoint(31.742830003291292, -106.43319207663062)
        iada.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        iada.icon

        val parque_central = GeoPoint(31.688028002239292, -106.4266794724959)
        val distacia = parque_central.distanceToAsDouble(iada.position)
        Log.v("distancia","la distancia es ${distacia}")
        map_view.controller.animateTo(parque_central)

        map_view.overlays.add(rodadora)
        map_view.overlays.add(iada)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapasTheme {
        vistaMapa()
    }
}