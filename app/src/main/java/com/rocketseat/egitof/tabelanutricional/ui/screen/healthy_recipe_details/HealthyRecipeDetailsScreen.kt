package com.rocketseat.egitof.tabelanutricional.ui.screen.healthy_recipe_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.rocketseat.egitof.tabelanutricional.R
import com.rocketseat.egitof.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.egitof.tabelanutricional.ui.components.BackButton
import com.rocketseat.egitof.tabelanutricional.ui.components.LoveButton
import com.rocketseat.egitof.tabelanutricional.ui.components.PrimaryButton
import com.rocketseat.egitof.tabelanutricional.ui.components.healthy_recipe_details.HealthyRecipeMainInfo
import com.rocketseat.egitof.tabelanutricional.ui.components.healthy_recipe_details.HealthyRecipeNutrientBar
import com.rocketseat.egitof.tabelanutricional.ui.theme.Primary
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing

@Composable
fun HealthyRecipeDetailsScreen(
    modifier: Modifier = Modifier,
    healthyRecipe: HealthyRecipe
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(sizing.lg),
            verticalArrangement = Arrangement.spacedBy(sizing.md)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackButton(
                    modifier = Modifier.shadow(
                        elevation = sizing.lg,
                        shape = CircleShape,
                        spotColor = Primary
                    ),
                    onClick = {}
                )
                LoveButton(
                    modifier = Modifier.shadow(
                        elevation = sizing.lg,
                        shape = CircleShape,
                        spotColor = Primary
                    ),
                    onClick = {}
                )
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .scale(1.2f),
                painter = painterResource(id = R.drawable.img_dish_with_shadow),
                contentScale = ContentScale.FillWidth,
                contentDescription = stringResource(id = R.string.imagem_item_tabela_nutricional)
            )

            HealthyRecipeMainInfo(
                recipeName = healthyRecipe.name,
                calories = healthyRecipe.calories,
                totalPortionInGrams = healthyRecipe.totalPortionInGrams
            )

            HealthyRecipeNutrientBarList(
                modifier = Modifier.padding(horizontal = sizing.md),
                healthyRecipe = healthyRecipe
            )

            Spacer(modifier = Modifier.height(sizing.sm))

            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sizing.x3l)
                    .padding(horizontal = sizing.md),
                text = stringResource(R.string.mais_detalhes)
            ) { }
        }
        Box(
            modifier = Modifier
                .zIndex(-1f)
                .align(Alignment.BottomStart)
                .clip(
                    RoundedCornerShape(
                        topStart = sizing.xl,
                        topEnd = sizing.xl
                    )
                )
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        )
    }
}

@Composable
private fun HealthyRecipeNutrientBarList(
    modifier: Modifier = Modifier,
    healthyRecipe: HealthyRecipe
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(sizing.md)
    ) {
        HealthyRecipeNutrientBar(
            name = stringResource(R.string.proteinas),
            value = healthyRecipe.proteins,
            maxValue = 35f
        )
        HealthyRecipeNutrientBar(
            name = stringResource(R.string.carboidratos),
            value = healthyRecipe.carbohydrates,
            maxValue = 35f
        )
        HealthyRecipeNutrientBar(
            name = stringResource(R.string.acucar),
            value = healthyRecipe.sugar,
            maxValue = 35f
        )
        HealthyRecipeNutrientBar(
            name = stringResource(R.string.gorduras),
            value = healthyRecipe.fat,
            maxValue = 35f
        )
    }
}

@Preview
@Composable
private fun HealthyRecipeDetailsScreenPreview() {
    TabelaNutricionalTheme {
        HealthyRecipeDetailsScreen(
            healthyRecipe = mockHealthyRecipes.first()
        )
    }
}