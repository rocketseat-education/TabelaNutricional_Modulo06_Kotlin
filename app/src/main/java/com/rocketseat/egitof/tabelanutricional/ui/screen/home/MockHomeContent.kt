package com.rocketseat.egitof.tabelanutricional.ui.screen.home

import com.rocketseat.egitof.tabelanutricional.R
import com.rocketseat.egitof.tabelanutricional.ui.components.home.HealthyRecipe
import com.rocketseat.egitof.tabelanutricional.ui.components.home.WellnessNews
import com.rocketseat.egitof.tabelanutricional.ui.components.home.WellnessNewsTag

val mockWellnessNews = listOf(
    WellnessNews(
        imageRes = R.drawable.img_nutritional_news_1,
        tags = listOf(
            WellnessNewsTag.WELLNESS,
            WellnessNewsTag.NUTRITION
        ),
        title = "A importância da tabela nutricional na alimentação consciente",
        readTimeInMinutes = 5
    ),
    WellnessNews(
        imageRes = R.drawable.img_nutritional_news_2,
        tags = listOf(
            WellnessNewsTag.FOOD_EDUCATION
        ),
        title = "Tabelas nutricionais: desvendando os segredos por trás dos rótulos",
        readTimeInMinutes = 4
    ),
    WellnessNews(
        imageRes = R.drawable.img_nutritional_news_3,
        tags = listOf(
            WellnessNewsTag.FOOD_EDUCATION
        ),
        title = "Como ler corretamente uma tabela nutricional",
        readTimeInMinutes = 6
    )
)

val mockHealthyRecipes = listOf(
    HealthyRecipe(
        name = "Salada variada",
        imageRes = R.drawable.img_assorted_salad,
        calories = 221.15f,
        proteins = 15.13f,
        carbohydrates = 18.40f
    ),
    HealthyRecipe(
        name = "Frango grelhado",
        imageRes = R.drawable.img_grilled_chicken,
        calories = 320.45f,
        proteins = 30.25f,
        carbohydrates = 22.80f
    ),
    HealthyRecipe(
        name = "Omelete de queijo e espinafre",
        imageRes = R.drawable.img_cheese_and_spinach_omelette,
        calories = 280.10f,
        proteins = 20.50f,
        carbohydrates = 10.30f
    ),
    HealthyRecipe(
        name = "Panqueca de aveia e banana",
        imageRes = R.drawable.img_oatmeal_and_banana_pancakes,
        calories = 250.60f,
        proteins = 8.75f,
        carbohydrates = 4.20f
    ),
    HealthyRecipe(
        name = "Tofu grelhado",
        imageRes = R.drawable.img_grilled_tofu,
        calories = 221.15f,
        proteins = 15.13f,
        carbohydrates = 18.40f
    ),
    HealthyRecipe(
        name = "Iogurte natural com granola",
        imageRes = R.drawable.img_natural_yogurt_with_granola,
        calories = 190.30f,
        proteins = 12.10f,
        carbohydrates = 30.15f
    )
)