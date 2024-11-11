package dev.trindadedev.swupdater.ui.screens.github.repository

import io.ktor.client.HttpClient

import kotlinx.coroutines.runBlocking

import dev.trindadedev.swupdater.ui.screens.github.models.Commit

class GitHubCommitsRepository(
  val client: HttpClient
) {
  
  suspend fun getCommits(
    owner: String,
    repo: String
  ): List<Commit> {
    return try {
      val url = "${Consts.BASE_URL}/$owner/$repo/commits"
      client.get(url).body()
    } catch (e: Exception) {
      emptyList()
    } finally {
      client.close()
    }
  }
}