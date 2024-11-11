package dev.trindadedev.swupdater.ui.screens.github.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*

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