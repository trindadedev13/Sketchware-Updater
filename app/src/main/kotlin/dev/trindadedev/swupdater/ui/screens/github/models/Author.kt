package dev.trindadedev.swupdater.ui.screens.github.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Author(
  val name: String,
  val date: Instant,
  val avatar: String = "https://github.com/$name.png"
)