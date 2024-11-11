package dev.trindadedev.swupdater.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

import kotlinx.serialization.json.Json

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

import dev.trindadedev.swupdater.ui.screens.github.repository.GitHubCommitsRepository
import dev.trindadedev.swupdater.ui.screens.github.viewmodel.GitHubCommitsViewModel

val GitHubModule = module {
  singleOf(::GitHubCommitsRepository)
  viewModelOf(::GitHubCommitsViewModel)
  single {
    HttpClient(Android) {
      install(ContentNegotiation) {
        json(
          Json {
            ignoreUnknownKeys = true 
          }
        )
      }
    }
  }
}
