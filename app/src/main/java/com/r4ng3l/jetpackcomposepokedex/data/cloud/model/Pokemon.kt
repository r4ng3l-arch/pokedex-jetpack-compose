package com.r4ng3l.jetpackcomposepokedex.data.cloud.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Double,
    val height: Double,
    val stats: List<Stat>,
    val types: List<Type>
)

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val stat: StatDetail
)

data class StatDetail(
    val name: String
)

data class Type(
    val type: TypeDetail
)

data class TypeDetail(
    val name: String
)
