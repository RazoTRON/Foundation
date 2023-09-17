package com.onix.foundation.domain.common

import kotlinx.coroutines.Dispatchers

class AppCoroutineDispatcher {
    val IO = Dispatchers.IO
    val Main = Dispatchers.Main
    val Default = Dispatchers.Default
    val Unconfined = Dispatchers.Unconfined
}