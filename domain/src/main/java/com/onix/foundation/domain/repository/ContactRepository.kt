package com.onix.foundation.domain.repository

import com.onix.foundation.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun getAll(): List<Contact>
    fun getById(contactId: String): Contact
    fun getPaged(pageSize: Int): Flow<androidx.paging.PagingData<Contact>>
}