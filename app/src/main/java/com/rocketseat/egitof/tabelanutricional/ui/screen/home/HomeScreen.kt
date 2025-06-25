package com.rocketseat.egitof.tabelanutricional.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.rocketseat.egitof.tabelanutricional.R
import com.rocketseat.egitof.tabelanutricional.ui.components.home.HealthyRecipe
import com.rocketseat.egitof.tabelanutricional.ui.components.home.HealthyRecipeCard
import com.rocketseat.egitof.tabelanutricional.ui.components.home.WelcomeHeader
import com.rocketseat.egitof.tabelanutricional.ui.components.home.WellnessNews
import com.rocketseat.egitof.tabelanutricional.ui.components.home.WellnessNewsCard
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing
import com.rocketseat.egitof.tabelanutricional.ui.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(sizing.md)
        ) {
            WelcomeHeader(userName = "Bernardo")
            Spacer(modifier = Modifier.height(sizing.x2l))
            Text(text = stringResource(R.string.saude_em_foco), style = Typography.headlineMedium)
            Spacer(modifier = Modifier.height(sizing.lg))
            WellnessNewsList(wellnessNewsList = mockWellnessNews, cardWidth = sizing.x5l)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F2F2))
                .padding(sizing.md)
        ) {
            Text(
                text = stringResource(R.string.tabela_nutricional),
                style = Typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(sizing.lg))
            HealthyRecipeList(healthyRecipes = mockHealthyRecipes)
        }
    }
}

@Composable
private fun WellnessNewsList(
    modifier: Modifier = Modifier,
    wellnessNewsList: List<WellnessNews>,
    cardWidth: Dp
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(sizing.md),
    ) {
        items(items = wellnessNewsList, key = { wellnessNews ->  wellnessNews.id }) { wellnessNews ->
            WellnessNewsCard(
                modifier = Modifier.width(cardWidth),
                wellnessNews = wellnessNews
            )
        }
    }
}

@Composable
private fun HealthyRecipeList(
    modifier: Modifier = Modifier,
    healthyRecipes: List<HealthyRecipe>
) {
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(sizing.md),
    ) {
        items(items = healthyRecipes, key = { healthyRecipe ->  healthyRecipe.id }) { healthyRecipe ->
            HealthyRecipeCard(
                healthyRecipe = healthyRecipe
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    TabelaNutricionalTheme {
        HomeScreen()
    }
}