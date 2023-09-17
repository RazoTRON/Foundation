package com.onix.foundation.details.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.onix.foundation.domain.common.AppResult
import com.onix.foundation.domain.usecase.GetContactByIdUseCase
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal data class DetailsState(
    val contactUI: ContactUI = ContactUI(id = "", name = "", phone = "", imageUrl = "", 0xFFFFFFFF)
)

internal class DetailsViewModel @AssistedInject constructor(
    @Assisted private val contactId: String,
    private val loadContactByIdUseCase: GetContactByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state = _state.asStateFlow()

    init {
        loadContact()
    }

    private fun loadContact() {
        viewModelScope.launch {
            val result = loadContactByIdUseCase.execute(contactId = contactId)

            when (result) {
                is AppResult.Success -> {
                    _state.emit(state.value.copy(contactUI = result.data.toUiModel()))
                }

                is AppResult.Error -> {
                    /* DO SOMETHING */
                }
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(contactId: String): DetailsViewModel
    }

    init {
        Log.d("VIEWMODEL", "Created Details ${this.toString().substringAfter("@")}")
    }

    override fun onCleared() {
        Log.d("VIEWMODEL", "Deleted")
        super.onCleared()
    }
}