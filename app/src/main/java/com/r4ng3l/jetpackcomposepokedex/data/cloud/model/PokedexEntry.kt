package com.r4ng3l.jetpackcomposepokedex.data.cloud.model

data class PokedexEntry(
    val results: List<PokedexEntryElements>
)

data class PokedexEntryElements(
    val id: Int? = null,
    val name: String,
    val url: String,
    //var types: List<Type> = emptyList()
)
