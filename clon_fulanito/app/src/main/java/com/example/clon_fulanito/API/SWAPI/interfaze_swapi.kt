package com.example.clon_fulanito.API.SWAPI

import com.example.clon_fulanito.modelos.swapi.NaveEspacial
import com.example.clon_fulanito.modelos.swapi.PaginaContenedora
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SWAPIInterfaz{
    @GET("starships")//esperamos modificaciones
    suspend fun obtener_naves(): PaginaContenedora

    @GET("starships/{id}")
    suspend fun obtener_nave(@Path("id")id:Int): NaveEspacial
}