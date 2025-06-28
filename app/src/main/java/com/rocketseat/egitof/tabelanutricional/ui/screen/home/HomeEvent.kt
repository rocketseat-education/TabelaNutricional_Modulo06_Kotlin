package com.rocketseat.egitof.tabelanutricional.ui.screen.home

sealed interface HomeEvent {
    data object OnInit: HomeEvent
}