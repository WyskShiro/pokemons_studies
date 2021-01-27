package com.example.testingcompose.domain

import javax.inject.Inject

class GetPokemons @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun getPokemons(): List<Pokemon> = pokemonRepository.getPokemons()
}