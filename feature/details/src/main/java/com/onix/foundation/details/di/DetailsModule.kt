package com.onix.foundation.details.di

import com.onix.foundation.domain.common.AppCoroutineDispatcher
import com.onix.foundation.domain.common.DomainExceptionHandler
import com.onix.foundation.domain.repository.ContactRepository
import com.onix.foundation.domain.usecase.GetContactByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DetailsModule {

    @Provides
    fun provideGetContactByIdUseCase(
        repository: ContactRepository,
        dispatcher: AppCoroutineDispatcher,
        handler: DomainExceptionHandler
    ): GetContactByIdUseCase {
        return GetContactByIdUseCase(repository, dispatcher, handler)
    }
}