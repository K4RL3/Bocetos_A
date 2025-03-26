package com.example.clonfulanito.vistas_modelos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clonfulanito.API.repositorioFulanito
import com.example.clonfulanito.modelo.Publicacion
import kotlinx.coroutines.launch

class FulanitoVM: ViewModel(){
    private val repositorio_de_datos = repositorioFulanito()

    private val _publicaciones = MutableLiveData<List<Publicacion>>()
    val publicaciones: LiveData<List<Publicacion>> = _publicaciones

    fun descargar_todas_public(){
        viewModelScope.launch {
            try {
                val publicaciones_obtenidas = repositorio_de_datos.obtenerPublic()
                _publicaciones.value = publicaciones_obtenidas
            }
            catch (error: Exception){
                Log.v("DESCARGA DE PUBLICACIONES", "${error.message}")
            }
        }
    }
}