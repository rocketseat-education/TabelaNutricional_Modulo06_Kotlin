package com.rocketseat.egitof.tabelanutricional.core.di

import com.rocketseat.egitof.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.MockHealthyRecipeLocalDataSourceImpl
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.MockWellnessNewsLocalDataSourceImpl
import com.rocketseat.egitof.tabelanutricional.data.datasource.local.WellnessNewsLocalDataSource
import com.rocketseat.egitof.tabelanutricional.data.repository.HomeContentRepositoryImpl
import com.rocketseat.egitof.tabelanutricional.domain.repository.HomeContentRepository
import com.rocketseat.egitof.tabelanutricional.domain.usecase.GetHealthyRecipeByIdUseCase
import com.rocketseat.egitof.tabelanutricional.domain.usecase.GetHomeContentUseCase
import com.rocketseat.egitof.tabelanutricional.ui.screen.healthy_recipe_details.HealthyRecipeDetailsViewModel
import com.rocketseat.egitof.tabelanutricional.ui.screen.home.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::HealthyRecipeDetailsViewModel)
    }

    val domainModule = module {
        factory { GetHomeContentUseCase(get()) }
        factory { GetHealthyRecipeByIdUseCase(get()) }
    }

    val dataModule = module {
        singleOf(::MockWellnessNewsLocalDataSourceImpl) {
            bind<WellnessNewsLocalDataSource>()
        }

        singleOf(::MockHealthyRecipeLocalDataSourceImpl) {
            bind<HealthyRecipeLocalDataSource>()
        }

        singleOf(::HomeContentRepositoryImpl) {
            bind<HomeContentRepository>()
        }
    }
}