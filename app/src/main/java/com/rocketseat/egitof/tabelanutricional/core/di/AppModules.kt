package com.rocketseat.egitof.tabelanutricional.core.di

import com.rocketseat.egitof.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.MockHealthyRecipeLocalDataSourceImpl
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.MockWellnessNewsLocalDataSourceImpl
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.WellnessNewsLocalDataSource
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {

    }

    val domainModule = module {

    }

    val dataModule = module {
        singleOf(::MockWellnessNewsLocalDataSourceImpl) {
            bind<WellnessNewsLocalDataSource>()
        }

        singleOf(::MockHealthyRecipeLocalDataSourceImpl) {
            bind<HealthyRecipeLocalDataSource>()
        }
    }
}