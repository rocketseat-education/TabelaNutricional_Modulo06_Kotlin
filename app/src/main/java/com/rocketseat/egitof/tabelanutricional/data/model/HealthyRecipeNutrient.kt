package com.rocketseat.egitof.tabelanutricional.data.model

import androidx.annotation.StringRes

data class HealthyRecipeNutrient(
    val value: Float,
    @StringRes val name: Int,
    val unit: NutrientUnit
)
