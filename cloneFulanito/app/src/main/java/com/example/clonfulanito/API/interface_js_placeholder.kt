package com.example.clonfulanito.API

import com.example.clonfulanito.modelo.Publicacion
import retrofit2.http.GET

interface FulanitoAPIServicio {
    // cuando se use la respuesta de internet se va a resolver como https://jsonplaceholder.typicode.com/posts
    @GET("/post")
    suspend fun obtenerPublic(): List<Publicacion>
}