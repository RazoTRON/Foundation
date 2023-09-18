package com.onix.foundation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import com.onix.foundation.home.ui.model.ContactUI
import com.onix.foundation.home.ui.util.LocalDimen

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onContactClick: (id: String) -> Unit,
) {
    val contacts = viewModel.contacts.collectAsLazyPagingItems()

    HomeScreenContent(contacts = contacts, onItemClick = onContactClick)
}

@Composable
private fun HomeScreenContent(
    contacts: LazyPagingItems<ContactUI>,
    modifier: Modifier = Modifier,
    onItemClick: (id: String) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(LocalDimen.current.listSpacedBy),
        modifier = modifier,
        contentPadding = PaddingValues(LocalDimen.current.screenPadding)
    ) {
        items(
            count = contacts.itemCount,
            key = contacts.itemKey { it.id },
        ) {
            ContactItem(
                contactUI = contacts[it]!!,
                modifier = Modifier
                    .fillParentMaxWidth()
                    .clickable { onItemClick(contacts[it]!!.id) })
        }
    }
}

@Composable
private fun ContactItem(contactUI: ContactUI, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .requiredSize(LocalDimen.current.imageSize)
                .clip(CircleShape)
                .background(Color(contactUI.imageColor))
                .padding(LocalDimen.current.imagePadding)
        ) {
            if (contactUI.imageUrl.isBlank()) {
                val firstLetter = contactUI.name.firstOrNull()?.toString() ?: ""

                Text(text = firstLetter, fontSize = LocalDimen.current.imageTextSize)
            } else {
                AsyncImage(model = contactUI.imageUrl, contentDescription = null)
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(LocalDimen.current.contactInfoPadding),
            modifier = Modifier.padding(LocalDimen.current.contactInfoPadding)
        ) {
            Text(text = contactUI.name, fontWeight = FontWeight.Bold)
            Text(text = contactUI.phone)
        }
    }
}