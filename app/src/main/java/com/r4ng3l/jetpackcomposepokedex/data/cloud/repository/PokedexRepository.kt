package com.r4ng3l.jetpackcomposepokedex.data.cloud.repository

import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.PokedexEntryElements
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Pokemon
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Type
import com.r4ng3l.jetpackcomposepokedex.data.cloud.retrofit.PokemonApiService

class PokedexRepository (private val api: PokemonApiService){
    suspend fun getPokemonList(): List<PokedexEntryElements> {
        return api.getPokemonList().results
    }

    suspend fun getPokemonDetails(id: Int): Pokemon {
        return api.getPokemonDetails(id = id)
    }

    // Fetch only the Pokémon types
    suspend fun getPokemonTypes(id: Int): List<Type> {
        return api.getPokemonDetails(id).types
    }
}