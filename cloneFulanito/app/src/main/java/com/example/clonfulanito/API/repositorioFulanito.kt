package com.example.clonfulanito.API

import com.example.clonfulanito.modelo.Comentario
import com.example.clonfulanito.modelo.Publicacion

class repositorioFulanito {
    private val servisio_api_jsPH = InstanciaRetroFitJSON_PH.consumirServicio

    suspend fun obtenerPublic(): List<Publicacion>{
        return servisio_api_jsPH.obtenerPublic()
    }

    suspend fun  obtener_comentsPublicacion(id: Int):List<Comentario>{
        return servisio_api_jsPH.obtener_coment(id)
    }
}