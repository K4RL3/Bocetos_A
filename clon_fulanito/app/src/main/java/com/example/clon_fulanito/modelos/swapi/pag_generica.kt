package com.example.clon_fulanito.modelos.swapi

import android.util.Log

data class PaginaContenedora(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results:List<NaveEspacial>
){
    fun indicar_pag_sig():Int?{
        return extraer_pag(next)
    }
    fun indicar_pag_ant():Int?{
        return extraer_pag(previous)
    }

    fun extraer_pag(pagina: String?):Int?{
        if (pagina!= null){
            val resultado = pagina.split("?page=")
            return resultado[1].toInt()
        }
        return null
    }
}