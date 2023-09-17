package com.onix.foundation.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.onix.foundation.details.ui.util.LocalDimen

@Composable
internal fun DetailsScreen(
    viewModel: DetailsViewModel,
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    DetailsContent(contactUI = state.value.contactUI)
}

@Composable
private fun DetailsContent(contactUI: ContactUI, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .requiredSize(LocalDimen.current.imageSize)
                .clip(CircleShape)
                .background(Color(contactUI.imageColor))
        ) {
            if (contactUI.imageUrl.isBlank()) {
                val firstLetter = contactUI.name.firstOrNull()?.toString() ?: ""

                Text(text = firstLetter, fontSize = LocalDimen.current.imageTextSize)
            } else {
                AsyncImage(model = contactUI.imageUrl, contentDescription = null)
            }
        }
        Text(text = contactUI.name, fontWeight = FontWeight.Bold)
        Text(text = contactUI.phone)
    }
}