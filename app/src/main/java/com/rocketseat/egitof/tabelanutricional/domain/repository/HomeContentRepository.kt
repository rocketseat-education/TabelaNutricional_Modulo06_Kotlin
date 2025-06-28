package com.rocketseat.egitof.tabelanutricional.domain.repository

import com.rocketseat.egitof.tabelanutricional.domain.model.HomeContent

interface HomeContentRepository {
    suspend fun getHomeContent(): HomeContent
}