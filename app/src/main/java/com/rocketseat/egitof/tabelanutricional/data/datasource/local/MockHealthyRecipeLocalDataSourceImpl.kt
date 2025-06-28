package com.rocketseat.egitof.tabelanutricional.data.datasource.local

import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes
import java.util.UUID

class MockHealthyRecipeLocalDataSourceImpl : HealthyRecipeLocalDataSource {
    override suspend fun getAllHealthyRecipes() = mockHealthyRecipes

    override suspend fun getHealthyRecipeById(id: String): HealthyRecipe? =
        mockHealthyRecipes.find { healthyRecipe -> healthyRecipe.id == UUID.fromString(id) }
}