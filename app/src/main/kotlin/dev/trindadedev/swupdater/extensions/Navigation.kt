package dev.trindadedev.swupdater.extensions

import androidx.navigation.NavHostController

fun <T: Any> NavHostController.navigateSingleTop(route: T) {
  val navController = this
  navController.navigate(route) {
    popUpTo(navController.graph.startDestinationId)
    launchSingleTop = true
  }
}