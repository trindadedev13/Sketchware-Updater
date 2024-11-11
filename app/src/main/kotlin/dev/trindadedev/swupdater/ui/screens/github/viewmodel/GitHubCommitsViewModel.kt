package dev.trindadedev.swupdater.ui.screens.github.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dev.trindadedev.swupdater.ui.screens.github.models.Commit
import dev.trindadedev.swupdater.ui.screens.github.repository.GitHubCommitsRepository

import kotlinx.coroutines.launch

class GitHubCommitsViewModel(
  private val repository: GitHubCommitsRepository
): ViewModel() {
  private var _commits = mutableStateOf<List<Commit>>(emptyList())
  val commits: List<Commit>
    get() = _commits.value
    
  init {
    viewModelScope.launch {
      getCommits()
    }
  }
  
  private suspend fun getCommits() {
    _commits.value = repository.getCommits(
      onwer = Repo.ONWER,
      repo = Repo.NAME
    )
  }
}