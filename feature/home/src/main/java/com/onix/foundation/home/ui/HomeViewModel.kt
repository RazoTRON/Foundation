package com.onix.foundation.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.onix.foundation.domain.usecase.GetContactsUseCase
import com.onix.foundation.home.ui.model.ContactUI
import com.onix.foundation.home.ui.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

private const val CONTACTS_PER_PAGE = 10

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase,
) : ViewModel() {

    val contacts: StateFlow<PagingData<ContactUI>> = getContacts()

    private fun getContacts(): StateFlow<PagingData<ContactUI>> {
        val flow = getContactsUseCase.execute(CONTACTS_PER_PAGE)

        return flow.map { pagingData ->
            pagingData.map { contact ->
                contact.toUiModel()
            }
        }
            .cachedIn(viewModelScope)
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
    }
}