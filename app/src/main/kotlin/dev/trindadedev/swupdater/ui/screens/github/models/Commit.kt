package dev.trindadedev.swupdater.ui.screens.github.models

import com.google.gson.annotations.SerializedName

data class Commit(
  @SerializedName("sha") val sha: String,
  @SerializedName("commit") val info: CommitInfo,
  @SerializedName("html_url") val url: String
)