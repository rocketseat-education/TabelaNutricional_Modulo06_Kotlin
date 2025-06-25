package com.rocketseat.egitof.tabelanutricional.ui.screen.healthy_recipe_details

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
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

private const val MAX_NUTRIENT_BAR_VALUE = 35f
private const val HEALTHY_RECIPE_IMAGE_SCALE = 1.2f
private const val HEALTHY_RECIPE_IMAGE_ROTATION = 360f
private const val HEALTHY_RECIPE_IMAGE_ANIMATION_DURATION_IN_MILLIS = 1000

@Composable
fun HealthyRecipeDetailsScreen(
    modifier: Modifier = Modifier,
    healthyRecipe: HealthyRecipe
) {
    var isImageVisible by remember { mutableStateOf(true) }
    val scale = remember { Animatable(initialValue = 0f) }
    val rotation = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = Unit) {
        isImageVisible = true

        scale.animateTo(
            targetValue = HEALTHY_RECIPE_IMAGE_SCALE,
            animationSpec = tween(
                durationMillis = HEALTHY_RECIPE_IMAGE_ANIMATION_DURATION_IN_MILLIS,
                easing = LinearEasing
            )
        )
    }

    LaunchedEffect(key1 = Unit) {
        rotation.animateTo(
            targetValue = HEALTHY_RECIPE_IMAGE_ROTATION,
            animationSpec = tween(
                durationMillis = HEALTHY_RECIPE_IMAGE_ANIMATION_DURATION_IN_MILLIS,
                easing = FastOutSlowInEasing
            )
        )
    }

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

            if(isImageVisible) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            scaleX = scale.value
                            scaleY = scale.value
                            rotationZ = rotation.value
                        }
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.img_dish_with_shadow),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = stringResource(id = R.string.imagem_item_tabela_nutricional)
                )
            }

            HealthyRecipeMainInfo(
                recipeName = healthyRecipe.name,
                calories = healthyRecipe.calories.value,
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
            name = stringResource(healthyRecipe.proteins.nameRes),
            value = healthyRecipe.proteins.value,
            maxValue = MAX_NUTRIENT_BAR_VALUE
        )
        HealthyRecipeNutrientBar(
            name = stringResource(healthyRecipe.carbohydrates.nameRes),
            value = healthyRecipe.carbohydrates.value,
            maxValue = MAX_NUTRIENT_BAR_VALUE
        )
        HealthyRecipeNutrientBar(
            name = stringResource(healthyRecipe.sugar.nameRes),
            value = healthyRecipe.sugar.value,
            maxValue = MAX_NUTRIENT_BAR_VALUE
        )
        HealthyRecipeNutrientBar(
            name = stringResource(healthyRecipe.fat.nameRes),
            value = healthyRecipe.fat.value,
            maxValue = MAX_NUTRIENT_BAR_VALUE
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