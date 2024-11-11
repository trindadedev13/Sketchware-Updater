package dev.trindadedev.swupdater.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.*

@Composable
fun DynamicListItem(
    listLength: Int,
    currentValue: Int,
    content: @Composable () -> Unit,
) {
    val shape = when (currentValue) {
        0 -> ItemShape.Top
        listLength -> ItemShape.Bottom
        else -> ItemShape.Middle
    }
    
    Card(
        shape = shape,
        elevation = CardDefaults.cardElevation(0.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        content()
    }
}