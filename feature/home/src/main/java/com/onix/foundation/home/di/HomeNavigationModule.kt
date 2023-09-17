package com.onix.foundation.home.di

import com.onix.foundation.core_ui.navigation.NavigationFactory
import com.onix.foundation.details_api.DetailsFeatureRoutes
import com.onix.foundation.home.api.HomeNavigationImpl
import com.onix.foundation.home_api.HomeFeatureRoutes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class HomeNavigationModule {

    @Provides
    fun provideHomeFeatureRoutes(detailsFeatureRoutes: DetailsFeatureRoutes): HomeFeatureRoutes {
        return HomeNavigationImpl(detailsFeatureRoutes)
    }

    @Provides
    @Singleton
    @IntoSet
    fun provideNavigationFactory(detailsFeatureRoutes: DetailsFeatureRoutes): NavigationFactory {
        return HomeNavigationImpl(detailsFeatureRoutes)
    }
}