package com.onix.foundation.domain.common

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DomainExceptionHandlerImpl : DomainExceptionHandler {
    override suspend fun <T> handle(
        dispatcher: CoroutineDispatcher,
        callable: suspend () -> T,
    ): AppResult<T> {
        return withContext(dispatcher) {
            try {
                AppResult.Success(callable())
            } catch (e: Exception) {
                Log.d(this.javaClass.simpleName, e.localizedMessage ?: e.stackTraceToString())

                AppResult.Error(e)
            }
        }
    }
}