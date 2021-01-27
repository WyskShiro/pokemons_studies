package com.example.testingcompose.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingcompose.domain.GetPokemons
import com.example.testingcompose.domain.Pokemon
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val getPokemons: GetPokemons
) : ViewModel() {

    private val pokemons = MutableLiveData<List<Pokemon>>()

    fun pokemons(): LiveData<List<Pokemon>> = pokemons

    init {
        viewModelScope.launch {
            val response: List<Pokemon> = getPokemons.getPokemons()
            pokemons.postValue(response)
        }
    }
}