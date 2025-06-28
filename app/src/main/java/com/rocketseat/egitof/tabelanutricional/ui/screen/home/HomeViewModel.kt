package com.rocketseat.egitof.tabelanutricional.ui.screen.home

import androidx.lifecycle.ViewModel
import com.rocketseat.egitof.tabelanutricional.domain.usecase.GetHomeContentUseCase

class HomeViewModel(
    private val getHomeContentUseCase: GetHomeContentUseCase
): ViewModel() {
}