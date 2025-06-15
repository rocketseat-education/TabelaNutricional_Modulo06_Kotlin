package com.rocketseat.egitof.tabelanutricional.ui.components.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocketseat.egitof.tabelanutricional.R
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing
import com.rocketseat.egitof.tabelanutricional.ui.theme.Typography
import java.nio.file.WatchEvent

enum class WellnessNewsTag(
    val description: String
) {
    WELLNESS(description = "Bem-estar"),
    NUTRITION(description = "Nutrição"),
    FOOD_EDUCATION(description = "Educação alimentar"),
}

data class WellnessNews(
    val title: String,
    @DrawableRes val imageRes: Int,
    val readTimeInMinutes: Int,
    val tags: List<WellnessNewsTag>
)

@Composable
fun WellnessNewsCard(
    modifier: Modifier = Modifier,
    wellnessNews: WellnessNews,
) {
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(wellnessNews.imageRes),
            contentDescription = stringResource(id = R.string.imagem_noticia_saude_em_foco)
        )
        LazyRow(
            modifier = Modifier.padding(top = sizing.sm),
            horizontalArrangement = Arrangement.spacedBy(sizing.xs)
        ) {
            items(count = wellnessNews.tags.size) { index ->
                Text(
                    modifier = Modifier
                        .border(
                            width = sizing.x1,
                            color = MaterialTheme.colorScheme.onSurface,
                            shape = RoundedCornerShape(size = sizing.xs)
                        )
                        .padding(horizontal = sizing.sm),
                    style = Typography.titleSmall.copy(fontSize = 12.sp),
                    text = wellnessNews.tags[index].description,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WellnessNewsCardPreview() {
    TabelaNutricionalTheme {
        LazyRow(
            modifier = Modifier.padding(sizing.md),
            horizontalArrangement = Arrangement.spacedBy(sizing.sm)
        ) {
            items(3) {
                WellnessNewsCard(
                    modifier = Modifier.width(sizing.x4l),
                    wellnessNews = WellnessNews(
                        title = "A importância da tabela nutricional na alimentação consciente",
                        readTimeInMinutes = 5,
                        imageRes = R.drawable.img_nutritional_news_1,
                        tags = listOf(
                            WellnessNewsTag.WELLNESS,
                            WellnessNewsTag.NUTRITION,
                        )
                    )
                )
            }
        }
    }
}
