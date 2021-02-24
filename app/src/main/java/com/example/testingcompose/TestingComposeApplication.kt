package com.example.testingcompose

import android.app.Application
import com.example.testingcompose.di.networkModule
import com.example.testingcompose.di.pokemonRepositoryModule
import com.example.testingcompose.di.useCasesModule
import com.example.testingcompose.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TestingComposeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@TestingComposeApplication)
            modules(networkModule, pokemonRepositoryModule, useCasesModule, viewModelModules)
        }
    }
}