package dev.trindadedev.swupdater.ui.components

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

object ItemShape {
  val Top = RoundedCornerShape(
    topStart = 24.dp,
    topEnd = 24.dp,
    bottomStart = 4.dp,
    bottomEnd = 4.dp
  )
  val Middle = RoundedCornerShape(4.dp)
  val Bottom = RoundedCornerShape(
    topStart = 4.dp,
    topEnd = 4.dp,
    bottomStart = 24.dp,
    bottomEnd = 24.dp
  )
}