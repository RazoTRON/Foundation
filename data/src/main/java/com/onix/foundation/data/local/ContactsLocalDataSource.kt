package com.onix.foundation.data.local

import com.onix.foundation.domain.model.Contact

interface ContactsLocalDataSource {
    fun getAll(): List<Contact>
    fun getById(contactId: String): Contact
    suspend fun getByPage(page: Int): List<Contact>
}