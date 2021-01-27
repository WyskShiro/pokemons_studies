package com.example.testingcompose.data

import com.example.testingcompose.domain.Pokemon
import com.example.testingcompose.domain.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonResponse>
}