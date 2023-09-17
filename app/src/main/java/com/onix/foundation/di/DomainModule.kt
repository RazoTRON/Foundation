package com.onix.foundation.di

import com.onix.foundation.domain.common.AppCoroutineDispatcher
import com.onix.foundation.domain.common.DomainExceptionHandler
import com.onix.foundation.domain.common.DomainExceptionHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideAppCoroutineDispatcher(): AppCoroutineDispatcher {
        return AppCoroutineDispatcher()
    }

    @Provides
    fun provideDomainExceptionHandler(): DomainExceptionHandler {
        return DomainExceptionHandlerImpl()
    }

}