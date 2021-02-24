package com.example.testingcompose.datasource.dataclass

import com.squareup.moshi.Json
import java.io.Serializable

data class PokemonResponse(
    @field:Json(name = "results") val results: List<ApiPokemon>
)

data class ApiPokemon(
    @field:Json(name = "name") val name: String? = null
): Serializable