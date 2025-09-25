package com.rocketseat.egitof.tabelanutricional.ui.screen.healthy_recipe_details

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HealthyRecipeDetailsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenLoadedNonFavoriteContentState_whenClickFavoriteButton_thenFavoriteButtonIsSelected() {
        //GIVEN
        val expectedHealthyRecipe = mockHealthyRecipes.first()

        composeTestRule.setContent {
            TabelaNutricionalTheme {
                HealthyRecipeDetailsScreen(
                    id = expectedHealthyRecipe.id.toString(),
                    uiState = HealthyRecipeDetailsUIState(
                        isLoading = false,
                        healthyRecipe = expectedHealthyRecipe,
                        isFavorite = false
                    ),
                    onEvent = {},
                    onNavigateBack = {}
                )
            }
        }

        //WHEN
        composeTestRule.onNodeWithContentDescription("Adicionar aos favoritos").performClick()

        //THEN
        composeTestRule.onNodeWithContentDescription("Adicionar aos favoritos").assertIsSelected()
    }

    @Test
    fun givenLoadedContentState_whenClickFavoriteButton_thenFavoriteButtonIsNotSelected() {
        //GIVEN
        val expectedHealthyRecipe = mockHealthyRecipes.first()

        composeTestRule.setContent {
            TabelaNutricionalTheme {
                HealthyRecipeDetailsScreen(
                    id = expectedHealthyRecipe.id.toString(),
                    uiState = HealthyRecipeDetailsUIState(
                        isLoading = false,
                        healthyRecipe = expectedHealthyRecipe,
                        isFavorite = true
                    ),
                    onEvent = {},
                    onNavigateBack = {}
                )
            }
        }

        //WHEN
        composeTestRule.onNodeWithContentDescription("Adicionar aos favoritos").performClick()

        //THEN
        composeTestRule.onNodeWithContentDescription("Adicionar aos favoritos").assertIsNotSelected()
    }

    @Test
    fun givenLoadedContentState_whenClickMoreDetailsButton_thenDetailsBottomSheetIsDisplayed() {
        //GIVEN
        val expectedHealthyRecipe = mockHealthyRecipes.first()

        composeTestRule.setContent {
            TabelaNutricionalTheme {
                HealthyRecipeDetailsScreen(
                    id = expectedHealthyRecipe.id.toString(),
                    uiState = HealthyRecipeDetailsUIState(
                        isLoading = false,
                        healthyRecipe = expectedHealthyRecipe,
                        isFavorite = false
                    ),
                    onEvent = {},
                    onNavigateBack = {}
                )
            }
        }

        //WHEN
        composeTestRule.onNodeWithContentDescription("Mostrar mais detalhes da receita")
            .performScrollTo()
            .performClick()

        //THEN
        composeTestRule.onNodeWithTag("MORE_DETAILS_CONTAINER_TAG").assertIsDisplayed()

    }
}