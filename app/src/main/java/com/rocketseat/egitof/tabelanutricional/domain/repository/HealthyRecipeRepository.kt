package com.rocketseat.egitof.tabelanutricional.domain.repository

import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe

interface HealthyRecipeRepository {
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?
    suspend fun checkIsFavorite(id: String): Boolean
    suspend fun updateIsFavorite(id: String, isFavorite: Boolean)
}