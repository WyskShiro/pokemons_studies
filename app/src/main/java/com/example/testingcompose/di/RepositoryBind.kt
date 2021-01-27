package com.example.testingcompose.di

import com.example.testingcompose.TestingComposeApplication
import com.example.testingcompose.data.PokemonRepositoryImpl
import com.example.testingcompose.domain.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
interface RepositoryBind {

    @Singleton
    @Binds
    fun bindPokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}