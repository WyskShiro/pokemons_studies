package com.example.testingcompose.di

import com.example.testingcompose.list.domain.GetPokemons
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetPokemons(get()) }
}