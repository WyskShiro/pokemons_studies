package com.example.testingcompose.domain

import com.squareup.moshi.Json
import java.io.Serializable

data class Pokemon(
    @field:Json(name = "name") val name: String? = null
): Serializable

data class PokemonResponse(
    @field:Json(name = "results") val results: List<Pokemon>
)