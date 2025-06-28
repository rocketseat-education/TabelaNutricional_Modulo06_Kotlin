package com.rocketseat.egitof.tabelanutricional.domain.model

import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.egitof.tabelanutricional.data.model.WellnessNews

data class HomeContent(
    val wellnessNewsList: List<WellnessNews>,
    val healthyRecipeList: List<HealthyRecipe>,
)
