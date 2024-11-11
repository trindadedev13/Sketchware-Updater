package dev.trindadedev.swupdater.navigation

import android.util.Log

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import dev.trindadedev.swupdater.navigation.routes.HomeRoute
import dev.trindadedev.swupdater.platform.LocalMainNavController
import dev.trindadedev.swupdater.ui.animations.navigation.NavigationAnimationTransitions
import dev.trindadedev.swupdater.ui.screens.home.HomeScreen
import dev.trindadedev.swupdater.ui.screens.home.HomeViewModel

import org.koin.androidx.compose.koinViewModel

import kotlin.reflect.typeOf

@Composable
fun MainNavHost() {
  val navController = LocalMainNavController.current

  NavHost(
    navController = navController,
    startDestination = HomeRoute,
    enterTransition = { NavigationAnimationTransitions.enterTransition },
    exitTransition = { NavigationAnimationTransitions.exitTransition },
    popEnterTransition = { NavigationAnimationTransitions.popEnterTransition },
    popExitTransition = { NavigationAnimationTransitions.popExitTransition },
  ) {
    composable<HomeRoute> {
      val viewModel = koinViewModel<HomeViewModel>()
      HomeScreen(viewModel)
    }
  }
}
