package dev.trindadedev.swupdater.ui.screens.github.models

data class Author(
  val name: String,
  val date: String,
  val avatar: String = "https://github.com/$name.png"
)