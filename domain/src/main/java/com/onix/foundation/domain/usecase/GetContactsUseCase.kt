package com.onix.foundation.domain.usecase

import androidx.paging.PagingData
import com.onix.foundation.domain.common.AppCoroutineDispatcher
import com.onix.foundation.domain.model.Contact
import com.onix.foundation.domain.repository.ContactRepository
import com.onix.foundation.domain.common.AppResult
import com.onix.foundation.domain.common.DomainExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.withContext

class GetContactsUseCase(
    private val repository: ContactRepository,
) {
    fun execute(pageSize: Int): Flow<PagingData<Contact>> {
        return repository.getPaged(pageSize)
    }
}