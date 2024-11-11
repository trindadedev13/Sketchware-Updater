package dev.trindadedev.swupdater.navigation

import android.util.Log

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import dev.trindadedev.swupdater.platform.LocalHomeNavController
import dev.trindadedev.swupdater.navigation.routes.NightlyBuildsRoute
import dev.trindadedev.swupdater.navigation.routes.GitHubCommitsRoute
import dev.trindadedev.swupdater.ui.animations.navigation.NavigationAnimationTransitions
import dev.trindadedev.swupdater.ui.screens.nightly.NightlyBuildsScreen
import dev.trindadedev.swupdater.ui.screens.github.GitHubCommitsScreen
import dev.trindadedev.swupdater.ui.screens.github.viewmodel.GitHubCommitsViewModel

import org.koin.androidx.compose.koinViewModel

import kotlin.reflect.typeOf

@Composable
fun BottomNavHost() {
  val navController = LocalHomeNavController.current

  NavHost(
    navController = navController,
    startDestination = NightlyBuildsRoute,
    enterTransition = { NavigationAnimationTransitions.enterTransition },
    exitTransition = { NavigationAnimationTransitions.exitTransition },
    popEnterTransition = { NavigationAnimationTransitions.popEnterTransition },
    popExitTransition = { NavigationAnimationTransitions.popExitTransition },
  ) {
    composable<NightlyBuildsRoute> {
      NightlyBuildsScreen()
    }
    
    composable<GitHubCommitsRoute> {
      val viewModel = koinViewModel<GitHubCommitsViewModel>()
      GitHubCommitsScreen(viewModel)
    }
  }
}
