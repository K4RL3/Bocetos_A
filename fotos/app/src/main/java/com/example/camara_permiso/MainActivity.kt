package com.example.camara_permiso

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraControl
import androidx.camera.core.CameraSelector
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.lifecycle.awaitInstance
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.example.camara_permiso.pantallas.PantallaCam
import com.example.camara_permiso.ui.theme.Camara_permisoTheme

class MainActivity : ComponentActivity() {
    private var solicitud_de_permiso =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){ esta_garantizado ->
            if (esta_garantizado) {
                VistaDelaCamara()
            }
            else{
                //dijo no
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (PackageManager.PERMISSION_GRANTED){
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) -> {
                VistaDelaCamara()
            }
            else -> {
                solicitud_de_permiso.launch(Manifest.permission.CAMERA)
            }
        }
        enableEdgeToEdge()
    }

    private fun VistaDelaCamara(){
        setContent {
            Camara_permisoTheme {
                Surface() {
                    PantallaCam()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Camara_permisoTheme {
        Greeting("Android")
    }
}

