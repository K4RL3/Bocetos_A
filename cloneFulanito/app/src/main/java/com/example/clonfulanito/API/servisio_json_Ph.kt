package com.example.clonfulanito.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanciaRetroFitJSON_PH{
    private const val url_base = "https://jsonplaceholder.typicode.com"

    private val servicio: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val consumirServicio: FulanitoAPIServicio by lazy {
        servicio.create(FulanitoAPIServicio::class.java )
    }
}