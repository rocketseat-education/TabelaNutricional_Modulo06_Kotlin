package com.rocketseat.egitof.tabelanutricional.data.datasource.local

import com.rocketseat.egitof.tabelanutricional.data.model.WellnessNews

interface WellnessNewsLocalDataSource {
    suspend fun getAllWellnessNews(): List<WellnessNews>
}