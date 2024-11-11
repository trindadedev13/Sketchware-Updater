package dev.trindadedev.swupdater.ui.screens.github.models

import kotlinx.serialization.Serializable

@Serializable
data class CommitInfo(
  val message: String,
  val author: Author
)