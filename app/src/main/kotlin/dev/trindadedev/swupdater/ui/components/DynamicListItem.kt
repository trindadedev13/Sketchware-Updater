package dev.trindadedev.swupdater.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.Modifier

@Composable
fun DynamicListItem(
  modifier: Modifier = Modifier,
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
    modifier = modifier,
    shape = shape,
    elevation = CardDefaults.cardElevation(0.dp),
  ) {
    content()
  }
}