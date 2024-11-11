package dev.trindadedev.swupdater.ui.screens.github.models

import kotlinx.datetime.Instant

data class Author(
  val name: Instant,
  val date: String,
  val avatar: String = "https://github.com/$name.png"
)