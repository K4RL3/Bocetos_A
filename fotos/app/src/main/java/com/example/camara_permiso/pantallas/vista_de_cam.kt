    package com.example.camara_permiso.pantallas

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.camara_permiso.R
import java.lang.reflect.Modifier
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color

    @Composable
    fun PantallaCam() {
        var lente_usado by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }
        val ciclo_vida_dueño = LocalLifecycleOwner.current
        val contexto = LocalContext.current

        val prevista = Preview.Builder().build()
        val vista_prev = remember { PreviewView(contexto) }
        val capturador_de_imagen = remember { ImageCapture.Builder().build() }

        // Alternar entre cámara delantera y trasera
        fun alternarCamara() {
            lente_usado = if (lente_usado == CameraSelector.LENS_FACING_BACK) {
                CameraSelector.LENS_FACING_FRONT
            } else {
                CameraSelector.LENS_FACING_BACK
            }
        }
        // Abre la galeria
        fun abrirGaleria(contexto: Context) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                type = "image/*"
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            contexto.startActivity(intent)
        }

        LaunchedEffect(lente_usado) {
            val proveedor_local_camara = contexto.obtenerProvedorDeCamara()
            proveedor_local_camara.unbindAll()

            val camarax_selector = CameraSelector.Builder().requireLensFacing(lente_usado).build()
            proveedor_local_camara.bindToLifecycle(ciclo_vida_dueño, camarax_selector, prevista, capturador_de_imagen)

            prevista.setSurfaceProvider(vista_prev.surfaceProvider)
        }

        Box(contentAlignment = Alignment.BottomCenter) {
            AndroidView(factory = { vista_prev }, modifier = androidx.compose.ui.Modifier.fillMaxSize())

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = { abrirGaleria(contexto) },
                    modifier = androidx.compose.ui.Modifier
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = CircleShape
                ) {
                    Icon(
                        painter = painterResource(id = R.mipmap.galeria_foreground),
                        contentDescription = "Abrir Galería")
                }

                androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.width(16.dp))

                Button(
                    onClick = { tomar_foto(capturador_de_imagen, contexto) },
                    modifier = androidx.compose.ui.Modifier
                        .weight(2f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = CircleShape
                ){
                    Icon(
                        painter = painterResource(id = R.mipmap.camara_foreground),
                        contentDescription = "Tomar Foto"
                    )
                }

                androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.width(16.dp))

                Button(
                    onClick = { alternarCamara() },
                    modifier = androidx.compose.ui.Modifier
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = CircleShape
                ) {
                    Icon(
                        painter = painterResource(id = R.mipmap.voltear_foreground),
                        contentDescription = "Cambiar Cámara"
                    )
                }
            }
        }
    }



private suspend fun Context.obtenerProvedorDeCamara(): ProcessCameraProvider =
    suspendCoroutine { continuacion ->
        ProcessCameraProvider.getInstance(this).also { proveedo_cam ->
            proveedo_cam.addListener({
                continuacion.resume(proveedo_cam.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }

private fun tomar_foto(capturador_img: ImageCapture, contexto: Context){
    val nombre_archivo ="Captura.jpge"

    val valores_img = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, nombre_archivo)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P){
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/nuestra_app")
        }
    }

    val saida_foto = ImageCapture.OutputFileOptions.Builder(
        contexto.contentResolver,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        valores_img
    ).build()

    capturador_img.takePicture(
        saida_foto,
        ContextCompat.getMainExecutor(contexto),
        object: ImageCapture.OnImageSavedCallback{
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                Log.v("EXITOCAP", "exito no ha pasado nada")
            }

            override fun onError(exception: ImageCaptureException) {
                Log.v("ERROR_CAPTRA", "paso algo malo : ${exception.message}")
            }

        }
    )

}
