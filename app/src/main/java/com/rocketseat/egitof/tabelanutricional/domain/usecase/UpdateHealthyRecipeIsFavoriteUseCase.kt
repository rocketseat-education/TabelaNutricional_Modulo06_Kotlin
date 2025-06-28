package com.rocketseat.egitof.tabelanutricional.domain.usecase

import com.rocketseat.egitof.tabelanutricional.domain.repository.HealthyRecipeRepository

class UpdateHealthyRecipeIsFavoriteUseCase(
    private val repository: HealthyRecipeRepository
) {

    suspend operator fun invoke(id: String, isFavorite: Boolean) {
        repository.updateIsFavorite(id, isFavorite)
    }
}