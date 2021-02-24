package com.example.testingcompose.datasource.service

import com.example.testingcompose.datasource.dataclass.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonResponse>
}