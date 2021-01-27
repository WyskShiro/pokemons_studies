package com.example.testingcompose.domain

interface PokemonRepository {

    suspend fun getPokemons(): List<Pokemon>
}