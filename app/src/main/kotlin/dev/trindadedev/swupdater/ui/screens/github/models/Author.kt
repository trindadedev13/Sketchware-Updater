package dev.trindadedev.swupdater.ui.screens.github.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Author(
  val name: String,
  val date: Instant
)

/*
 * This author have more info
 */
@Serializable
data class FullAuthor(
  @SerialName("avatar_url") val avatar: String
)