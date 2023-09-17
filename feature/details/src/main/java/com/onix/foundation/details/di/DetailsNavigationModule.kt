package com.onix.foundation.details.di

import com.onix.foundation.core_ui.navigation.NavigationFactory
import com.onix.foundation.details.api.DetailsNavigationImpl
import com.onix.foundation.details.ui.DetailsViewModel
import com.onix.foundation.details_api.DetailsFeatureRoutes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DetailsNavigationModule {

    @Provides
    @Singleton
    internal fun provideDetailsFeatureRoutes(
        viewModelAssistedFactory: DetailsViewModel.Factory
    ): DetailsFeatureRoutes {
        return DetailsNavigationImpl(viewModelAssistedFactory)
    }

    @Provides
    @Singleton
    @IntoSet
    internal fun provideDetailsNavigationFactory(
        viewModelAssistedFactory: DetailsViewModel.Factory
    ): NavigationFactory {
        return DetailsNavigationImpl(viewModelAssistedFactory)
    }
}
