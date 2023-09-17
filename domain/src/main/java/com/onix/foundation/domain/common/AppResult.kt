package com.onix.foundation.domain.common

sealed class AppResult<T> {
    class Success<T>(val data: T) : AppResult<T>()
    class Error<T>(val exception: Exception) : AppResult<T>()
}
