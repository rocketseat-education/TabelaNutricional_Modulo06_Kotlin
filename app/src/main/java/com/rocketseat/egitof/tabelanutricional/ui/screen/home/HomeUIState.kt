package com.rocketseat.egitof.tabelanutricional.ui.screen.home

import com.rocketseat.egitof.tabelanutricional.domain.model.HomeContent

data class HomeUIState(
    val isLoading: Boolean = false,
    val homeContent: HomeContent? = null,
    val userName: String? = null,
)
