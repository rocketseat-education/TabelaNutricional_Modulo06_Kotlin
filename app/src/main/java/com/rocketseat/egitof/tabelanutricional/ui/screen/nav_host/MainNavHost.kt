package com.rocketseat.egitof.tabelanutricional.ui.screen.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rocketseat.egitof.tabelanutricional.core.navigation.UIRoute
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.egitof.tabelanutricional.ui.screen.healthy_recipe_details.HealthyRecipeDetailsScreen
import com.rocketseat.egitof.tabelanutricional.ui.screen.home.HomeScreen

@Composable
fun MainNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(modifier = modifier, navController = navController, startDestination = UIRoute.Home) {
        composable<UIRoute.Home> {
            HomeScreen(
                onNavigateToDetails = { selectedHealthyRecipeId ->
                    navController.navigate(
                        UIRoute.HealthRecipeDetails(
                            healthyRecipeId = selectedHealthyRecipeId
                        )
                    )
                },
            )
        }

        composable<UIRoute.HealthRecipeDetails> { navBackStackEntry ->
            val healthyRecipeId = navBackStackEntry.arguments?.getString("healthyRecipeId")
            healthyRecipeId?.let {
                val healthyRecipe =
                    mockHealthyRecipes.find { healthyRecipe -> healthyRecipeId == healthyRecipe.id.toString() }
                if(healthyRecipe == null)  return@composable

                HealthyRecipeDetailsScreen(
                    healthyRecipe = healthyRecipe,
                    onNavigateBack = { navController.popBackStack() },
                    onClickFavorite = {}
                )
            }
        }
    }
}