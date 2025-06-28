package com.rocketseat.egitof.tabelanutricional.data.datasource.local

import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe

interface HealthyRecipeLocalDataSource {
    suspend fun getAllHealthyRecipes(): List<HealthyRecipe>
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?
}