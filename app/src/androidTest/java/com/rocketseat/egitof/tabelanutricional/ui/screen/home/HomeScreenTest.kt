package com.rocketseat.egitof.tabelanutricional.ui.screen.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockWellnessNews
import com.rocketseat.egitof.tabelanutricional.domain.model.HomeContent
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenLoadingState_whenHomeScreenIsDisplayed_thenProgressIndicatorIsShown() {
        //GIVEN
        val expectedUiState = HomeUIState(isLoading = true)

        //WHEN
        composeTestRule.setContent {
            TabelaNutricionalTheme {
                HomeScreen(
                    uiState = expectedUiState,
                    onEvent = {},
                    onNavigateToDetails = {}
                )
            }
        }

        //THEN

        composeTestRule.onNodeWithTag("HOME_LOADING_CONTENT").assertIsDisplayed()
        composeTestRule.onNodeWithTag("HOME_CONTAINER_CONTENT").assertDoesNotExist()
    }

    @Test
    fun givenContentLoadedState_whenHomeScreenIsDisplayed_thenContentIsShown() {
        //GIVEN
        val expectedUiState = HomeUIState(
            isLoading = false,
            userName = "Bernardo",
            homeContent = HomeContent(
                wellnessNewsList = mockWellnessNews,
                healthyRecipeList = mockHealthyRecipes
            )
        )

        //WHEN
        composeTestRule.setContent {
            TabelaNutricionalTheme {
                HomeScreen(
                    uiState = expectedUiState,
                    onEvent = {},
                    onNavigateToDetails = {}
                )
            }
        }

        //THEN
        composeTestRule.onNodeWithTag("HOME_LOADING_CONTENT").assertDoesNotExist()
        composeTestRule.onNodeWithTag("HOME_CONTAINER_CONTENT").assertIsDisplayed()
        composeTestRule.onNodeWithText("Olá Bernardo!").assertIsDisplayed()
        composeTestRule.onNodeWithText(mockWellnessNews.first().title).assertIsDisplayed()
        composeTestRule.onNodeWithText(mockHealthyRecipes.first().name).assertIsDisplayed()
    }
}