package com.example.testingcompose.list.domain

class GetPokemons constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun getPokemons(): List<Pokemon> = pokemonRepository.getPokemons()
}