package com.rocketseat.egitof.tabelanutricional.domain.usecase

import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.egitof.tabelanutricional.domain.repository.HealthyRecipeRepository

class GetHealthyRecipeByIdUseCase(
    private val repository: HealthyRecipeRepository
) {

    suspend operator fun invoke(id: String): HealthyRecipe? = repository.getHealthyRecipeById(id)
}