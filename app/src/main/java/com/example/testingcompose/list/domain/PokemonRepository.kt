package com.example.testingcompose.list.domain

interface PokemonRepository {

    suspend fun getPokemons(): List<Pokemon>
}