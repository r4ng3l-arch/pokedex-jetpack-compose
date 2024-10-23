package com.r4ng3l.jetpackcomposepokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.PokedexEntryElements
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Pokemon
import com.r4ng3l.jetpackcomposepokedex.data.cloud.repository.PokedexRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokedexViewModel(private val repository: PokedexRepository) : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<PokedexEntryElements>>(value = listOf())
    val pokemonList: StateFlow<List<PokedexEntryElements>> = _pokemonList

    private val _pokemonDetails = MutableStateFlow<Pokemon?>(value = null)
    val pokemonDetails: StateFlow<Pokemon?> = _pokemonDetails

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            val entries = repository.getPokemonList()
            _pokemonList.value = entries.map { entry ->
                val id = entry.url.split("/").last { it.isNotEmpty() }.toInt()
                entry.copy(id = id)
                //val types = repository.getPokemonTypes(id = id)
                //entry.copy(id = id, types = types)  // Copy and add the types to each entry and also the id
            }
        }
    }

    fun fetchPokemonDetails(id: Int) {
        viewModelScope.launch {
            _pokemonDetails.value = repository.getPokemonDetails(id = id)
        }
    }
}