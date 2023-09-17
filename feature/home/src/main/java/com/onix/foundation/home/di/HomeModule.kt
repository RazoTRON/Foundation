package com.onix.foundation.home.di

import com.onix.foundation.domain.repository.ContactRepository
import com.onix.foundation.domain.usecase.GetContactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {

    @Provides
    fun provideGetContactsUseCase(
        repository: ContactRepository,
    ): GetContactsUseCase {
        return GetContactsUseCase(repository)
    }
}