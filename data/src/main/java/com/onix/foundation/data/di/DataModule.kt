package com.onix.foundation.data.di

import com.onix.foundation.data.local.ContactsFakeDataSource
import com.onix.foundation.data.local.ContactsLocalDataSource
import com.onix.foundation.data.repository.ContactRepositoryImpl
import com.onix.foundation.domain.repository.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(contactsLocalDataSource: ContactsLocalDataSource): ContactRepository {
        return ContactRepositoryImpl(contactsLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideContactsLocalDataSource(): ContactsLocalDataSource {
        return ContactsFakeDataSource()
    }
}