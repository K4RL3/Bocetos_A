package com.example.clon_fulanito.API.SWAPI

import com.example.clon_fulanito.modelos.swapi.NaveEspacial
import com.example.clon_fulanito.modelos.swapi.PaginaContenedora

class Repositorio_SWapi{
    private val servico_swapi = InstanciaRetroFitSWAPI.consumir_servicio

    suspend fun obtener_naves_espaciales(): PaginaContenedora{
        return servico_swapi.obtener_naves()
    }
    suspend fun ovtener_nave(id:Int): NaveEspacial{
        return servico_swapi.obtener_nave(id)
    }
}