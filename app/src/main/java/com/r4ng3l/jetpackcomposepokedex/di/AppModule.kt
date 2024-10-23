package com.r4ng3l.jetpackcomposepokedex.di

import com.r4ng3l.jetpackcomposepokedex.data.cloud.repository.PokedexRepository
import com.r4ng3l.jetpackcomposepokedex.data.cloud.retrofit.PokemonApiService
import com.r4ng3l.jetpackcomposepokedex.viewmodel.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { ApiClient.instance }
    single { PokedexRepository(get()) }
    viewModel { PokedexViewModel(get()) }
}

object ApiClient {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val instance: PokemonApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApiService::class.java)
    }
}