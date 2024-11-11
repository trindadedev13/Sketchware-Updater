package dev.trindadedev.swupdater.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

import dev.trindadedev.swupdater.navigation.routes.NightlyBuildsRoute
import dev.trindadedev.swupdater.navigation.routes.GitHubCommitsRoute

class HomeViewModel: ViewModel() {
  private var _currentRoute by mutableStateOf<Any>(NightlyBuildsRoute)
  
  val currentRoute: Any
    get() = _currentRoute
    
  fun <T: Any> setCurrentRoute(route: T) {
    _currentRoute = route
  }
}