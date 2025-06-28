package com.rocketseat.egitof.tabelanutricional.ui.screen.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rocketseat.egitof.tabelanutricional.core.navigation.UIRoute
import com.rocketseat.egitof.tabelanutricional.ui.screen.home.HomeScreen

@Composable
fun MainNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = UIRoute.Home) {
        composable<UIRoute.Home> {
            HomeScreen(
                onNavigateToDetails = { healthyRecipeId ->
                    navController.navigate(
                        UIRoute.HealthRecipeDetails(
                            healthyRecipeId = healthyRecipeId
                        )
                    )
                },
            )
        }
    }
}