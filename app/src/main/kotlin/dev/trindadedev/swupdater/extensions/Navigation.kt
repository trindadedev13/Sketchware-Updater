package dev.trindadedev.swupdater.extensions

import androidx.navigation.NavHostController

fun <T: Any> NavHostController.navigateSingleTop(route: T) {
  this.navigate(route) {
    popUpTo(this.graph.startDestinationId)
    launchSingleTop = true
  }
}