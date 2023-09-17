package com.onix.foundation.details.ui.util

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal val LocalDimen = compositionLocalOf { Dimensions() }

internal data class Dimensions(
    val listSpacedBy: Dp = 6.dp,
    val screenPadding: Dp = 8.dp,
    val imageSize: Dp = 150.dp,
    val imagePadding: Dp = 20.dp,
    val imageTextSize: TextUnit = 24.sp,
    val contactInfoPadding: Dp = 10.dp
) {
}