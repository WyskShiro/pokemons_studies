package com.example.testingcompose.datasource.repository

import com.example.testingcompose.datasource.service.PokemonService
import com.example.testingcompose.datasource.util.Repository
import com.example.testingcompose.datasource.util.handleResponse
import com.example.testingcompose.list.domain.Pokemon
import com.example.testingcompose.list.domain.PokemonRepository

class PokemonRepositoryImpl constructor(
    private val pokemonService: PokemonService
) : Repository, PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        return handleResponse(pokemonService.getPokemons()).results.map { Pokemon(it.name) }
    }
}