package com.rocketseat.egitof.tabelanutricional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rocketseat.egitof.tabelanutricional.ui.screen.nav_host.MainNavHost
import com.rocketseat.egitof.tabelanutricional.ui.theme.TabelaNutricionalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TabelaNutricionalTheme {
                    MainNavHost()
            }
        }
    }
}
