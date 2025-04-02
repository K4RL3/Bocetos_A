package com.example.clon_fulanito.vista_modelos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clon_fulanito.API.SWAPI.Repositorio_SWapi
import com.example.clon_fulanito.modelos.swapi.PaginaContenedora
import kotlinx.coroutines.launch

class SWAPImodelo:ViewModel(){
    private val repositorio = Repositorio_SWapi()
    private val _pag_actual = MutableLiveData<PaginaContenedora>()
    val pagina_actual: LiveData<PaginaContenedora> = _pag_actual

    fun descargar_pag(){
        viewModelScope.launch {
            try {
                val pagina =repositorio.obtener_naves_espaciales()
                _pag_actual.value =pagina
            }
            catch (error: Exception){
                Log.v("Descarga pag SWAPI","${error.message}")
            }
        }
    }
}