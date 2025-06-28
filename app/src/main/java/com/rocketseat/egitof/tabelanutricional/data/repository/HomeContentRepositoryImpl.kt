package com.rocketseat.egitof.tabelanutricional.data.repository

import com.rocketseat.egitof.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.WellnessNewsLocalDataSource
import com.rocketseat.egitof.tabelanutricional.domain.model.HomeContent
import com.rocketseat.egitof.tabelanutricional.domain.repository.HomeContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeContentRepositoryImpl(
    private val healthyRecipeLocalDataSource: HealthyRecipeLocalDataSource,
    private val wellnessNewsLocalDataSource: WellnessNewsLocalDataSource
): HomeContentRepository {
    override suspend fun getHomeContent(): HomeContent = withContext(Dispatchers.Default) {
        val wellnessNewsList = wellnessNewsLocalDataSource.getAllWellnessNews()
        val healthyRecipeList = healthyRecipeLocalDataSource.getAllHealthyRecipes()

        return@withContext HomeContent(
            wellnessNewsList = wellnessNewsList,
            healthyRecipeList = healthyRecipeList
        )
    }
}
