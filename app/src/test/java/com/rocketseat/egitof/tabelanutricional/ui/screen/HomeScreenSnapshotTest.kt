package com.rocketseat.egitof.tabelanutricional.ui.screen

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockWellnessNews
import com.rocketseat.egitof.tabelanutricional.domain.model.HomeContent
import com.rocketseat.egitof.tabelanutricional.ui.screen.home.HomeScreen
import com.rocketseat.egitof.tabelanutricional.ui.screen.home.HomeUIState
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import org.junit.Rule
import org.junit.Test

class HomeScreenSnapshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun `home screen content loaded snapshot test`() {
        val expectedUIState = HomeUIState(
            isLoading = false,
            homeContent = HomeContent(
                wellnessNewsList = mockWellnessNews,
                healthyRecipeList = mockHealthyRecipes
            )
        )

        paparazzi.snapshot {
            TabelaNutricionalTheme {
                HomeScreen(
                   uiState = expectedUIState,
                     onEvent = {},
                     onNavigateToDetails = {}
                )
            }
        }
    }
}