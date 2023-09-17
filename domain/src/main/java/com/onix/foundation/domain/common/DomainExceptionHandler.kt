package com.onix.foundation.domain.common

import kotlinx.coroutines.CoroutineDispatcher

interface DomainExceptionHandler {
    suspend fun <T> handle(
        dispatcher: CoroutineDispatcher,
        callable: suspend () -> T,
    ): AppResult<T>
}