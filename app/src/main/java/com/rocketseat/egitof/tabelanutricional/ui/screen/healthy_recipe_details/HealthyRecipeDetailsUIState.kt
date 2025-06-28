package com.rocketseat.egitof.tabelanutricional.ui.screen.healthy_recipe_details

import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe

data class HealthyRecipeDetailsUIState(
    val isLoading: Boolean = false,
    val healthyRecipe: HealthyRecipe? = null,
    val isFavorite: Boolean = false,
)
