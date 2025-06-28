package com.rocketseat.egitof.tabelanutricional.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface UIRoute {

    @Serializable
    data object Home : UIRoute

    @Serializable
    data class HealthRecipeDetails(val healthyRecipeId: String): UIRoute

}