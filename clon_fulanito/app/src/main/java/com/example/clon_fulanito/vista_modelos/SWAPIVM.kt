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

    fun descargar_pag(pagina:Int = 1){
        Log.v("pag a descargar", "pagina: ${pagina}")
        viewModelScope.launch {
            try {
                val pagina =repositorio.obtener_naves_espaciales(pagina)
                _pag_actual.value =pagina
            }
            catch (error: Exception){
                Log.v("Descarga pag SWAPI","${error.message}")
            }
        }
    }

    fun pasar_a_sig_pag() {
        val pagina_sig: Int? =pagina_actual.value?.indicar_pag_sig()
        if(pagina_sig!= null){
            descargar_pag(pagina_sig)
        }
    }

    fun pasar_a_ant_pag() {
        val pagina_ant: Int? =pagina_actual.value?.indicar_pag_sig()
        if(pagina_ant != null){
            descargar_pag(pagina_ant)
        }
    }
}