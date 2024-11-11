package dev.trindadedev.swupdater.platform

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalMainNavController = compositionLocalOf<NavHostController> {
  noLocalProvidedFor("LocalMainNavController")
}

val LocalHomeNavController = compositionLocalOf<NavHostController> {
  noLocalProvidedFor("LocalHomeNavController")
}

internal fun noLocalProvidedFor(name: String): Nothing {
  error("CompositionLocal $name not present")
}
