package com.r4ng3l.jetpackcomposepokedex.data.cloud.retrofit

import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.PokedexEntry
import com.r4ng3l.jetpackcomposepokedex.data.cloud.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 251,
        @Query("offset") offset: Int = 0
    ): PokedexEntry

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): Pokemon
}
