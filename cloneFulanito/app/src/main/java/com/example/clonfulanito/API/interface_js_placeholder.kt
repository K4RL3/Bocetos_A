package com.example.clonfulanito.API

import com.example.clonfulanito.modelo.Comentario
import com.example.clonfulanito.modelo.Publicacion
import retrofit2.http.GET
import retrofit2.http.Path

interface FulanitoAPIServicio {
    // cuando se use la respuesta de internet se va a resolver como https://jsonplaceholder.typicode.com/posts
    @GET("/post")
    suspend fun obtenerPublic(): List<Publicacion>

    @GET("/post/{id}/coments")
    suspend fun obtener_coment(@Path("id") id: Int): List<Comentario>
}