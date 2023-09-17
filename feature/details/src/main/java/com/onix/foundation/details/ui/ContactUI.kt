package com.onix.foundation.details.ui

import com.onix.foundation.domain.model.Contact

internal data class ContactUI(
    val id: String,
    val name: String,
    val phone: String,
    val imageUrl: String,
    val imageColor: Long
)

internal fun Contact.toUiModel() = ContactUI(id, name, phone, imageUrl, imageColor)