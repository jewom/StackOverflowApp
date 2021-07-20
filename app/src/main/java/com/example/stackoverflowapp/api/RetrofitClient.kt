package com.example.stackoverflowapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.stackexchange.com/2.2/"

val retrofitClient: StackOverflowService by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) // on définit l'URL de base
        .client(OkHttpClient()) // on définit un client Http (OkHttp étant le client par défaut de Retrofit2)
        .addConverterFactory(GsonConverterFactory.create()) // pour permettre le serialisation/deserialisation de nos Json en objet Kotlin
        .build()
    return@lazy retrofit.create(StackOverflowService::class.java)
}