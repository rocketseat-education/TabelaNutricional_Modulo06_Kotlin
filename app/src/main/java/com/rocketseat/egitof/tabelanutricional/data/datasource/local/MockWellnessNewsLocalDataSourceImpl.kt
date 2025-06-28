package com.rocketseat.egitof.tabelanutricional.data.datasource.local

import com.rocketseat.egitof.tabelanutricional.data.model.mock.mockWellnessNews

class MockWellnessNewsLocalDataSourceImpl: WellnessNewsLocalDataSource {
    override suspend fun  getAllWellnessNews() = mockWellnessNews
}