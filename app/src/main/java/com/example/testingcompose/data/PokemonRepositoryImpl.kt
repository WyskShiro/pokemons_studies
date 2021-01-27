package com.example.testingcompose.data

import com.example.testingcompose.domain.Pokemon
import com.example.testingcompose.domain.PokemonRepository
import com.example.testingcompose.util.ApiResponse
import com.example.testingcompose.util.Repository
import com.example.testingcompose.util.handleResponse
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonService: PokemonService
) : Repository, PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        return handleResponse(pokemonService.getPokemons()).results
    }
}