package com.onix.foundation.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.onix.foundation.data.local.ContactsLocalDataSource
import com.onix.foundation.data.local.ContactsPagerSource
import com.onix.foundation.domain.model.Contact
import com.onix.foundation.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

internal class ContactRepositoryImpl(
    private val contactsLocalDataSource: ContactsLocalDataSource
) : ContactRepository {

    override fun getAll(): List<Contact> {
        return contactsLocalDataSource.getAll()
    }

    override fun getPaged(pageSize: Int): Flow<PagingData<Contact>> {

        return Pager(
            config = PagingConfig(pageSize = pageSize)
        ) {
            ContactsPagerSource(contactsLocalDataSource)
        }.flow
    }

    override fun getById(contactId: String): Contact {
        return contactsLocalDataSource.getById(contactId)
    }
}