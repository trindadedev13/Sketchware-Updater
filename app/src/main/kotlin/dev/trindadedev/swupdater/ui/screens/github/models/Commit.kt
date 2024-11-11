package dev.trindadedev.swupdater.ui.screens.github.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Commit(
  @SerialName("sha") val sha: String,
  @SerialName("commit") val info: CommitInfo,
  @SerialName("html_url") val url: String,
  @SerialName("author") val fullAuthor: FullAuthor
)