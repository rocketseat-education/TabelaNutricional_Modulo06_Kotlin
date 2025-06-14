package com.rocketseat.egitof.tabelanutricional.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.rocketseat.egitof.tabelanutricional.R
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.egitof.tabelanutricional.ui.theme.Typography

@Composable
fun WelcomeHeader(
    modifier: Modifier = Modifier,
    hasNewNotification: Boolean = true,
    onNotificationBellClick: () -> Unit = { }
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(TabelaNutricionalTheme.sizing.x2l),
            painter = painterResource(R.drawable.img_male_profile),
            contentDescription = stringResource(R.string.imagem_perfil_usuario)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(TabelaNutricionalTheme.sizing.sm)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Olá Marcos!",
                style = Typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(TabelaNutricionalTheme.sizing.x2))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Seja bem-vindo de volta!",
                style = Typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSecondary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeHeaderPreview() {
    TabelaNutricionalTheme {
        WelcomeHeader(modifier = Modifier.padding(TabelaNutricionalTheme.sizing.md))
    }
}