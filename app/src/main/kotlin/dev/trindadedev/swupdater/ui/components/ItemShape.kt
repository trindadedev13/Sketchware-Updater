package dev.trindadedev.swupdater.ui.components

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

object ItemShape {
  val Top = RoundedCornerShape(
    topStart = 10.dp,
    topEnd = 10.dp
  )
  val Middle = RoundedCornerShape(0.dp)
  val Bottom = RoundedCornerShape(
    bottomStart = 10.dp,
    bottomEnd = 10.dp
  )
}