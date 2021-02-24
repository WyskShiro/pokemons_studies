package com.example.testingcompose.di

import com.example.testingcompose.datasource.repository.PokemonRepositoryImpl
import com.example.testingcompose.list.domain.PokemonRepository
import org.koin.dsl.module

val pokemonRepositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}
