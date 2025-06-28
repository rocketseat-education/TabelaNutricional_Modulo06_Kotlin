package com.rocketseat.egitof.tabelanutricional.data.datasource.local

import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes

class MockHealthyRecipeLocalDataSourceImpl: HealthyRecipeLocalDataSource {
    override suspend fun  getAllHealthyRecipes() = mockHealthyRecipes
}