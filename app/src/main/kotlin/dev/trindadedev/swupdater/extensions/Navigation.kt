package dev.trindadedev.swupdater.extensions

import androidx.navigation.NavHostController

fun <T> NavHostController.navigateSingleTop(T: route) {
  this.navigate(route) {
    popUpTo(this.graph.startDestinationId)
    launchSingleTop = true
  }
}