package com.onix.foundation.domain.usecase

import com.onix.foundation.domain.common.AppCoroutineDispatcher
import com.onix.foundation.domain.common.AppResult
import com.onix.foundation.domain.common.DomainExceptionHandler
import com.onix.foundation.domain.model.Contact
import com.onix.foundation.domain.repository.ContactRepository

class GetContactByIdUseCase(
    private val repository: ContactRepository,
    private val dispatcher: AppCoroutineDispatcher,
    private val handler: DomainExceptionHandler,
) {
    suspend fun execute(contactId: String): AppResult<Contact> {
        return handler.handle(dispatcher.IO) { repository.getById(contactId) }
    }
}