package com.rocketseat.egitof.tabelanutricional.domain.usecase

import com.rocketseat.egitof.tabelanutricional.domain.repository.HealthyRecipeRepository

class IsHealthyRecipeFavoriteUseCase(
    private val repository: HealthyRecipeRepository
) {
    suspend operator fun invoke(id: String): Boolean = repository.checkIsFavorite(id)
}