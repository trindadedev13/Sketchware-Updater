package dev.trindadedev.swupdater.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.input.nestedscroll.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.navigation.compose.rememberNavController

import dev.trindadedev.swupdater.Strings
import dev.trindadedev.swupdater.navigation.BottomNavHost
import dev.trindadedev.swupdater.platform.LocalHomeNavController
import dev.trindadedev.swupdater.extensions.navigateSingleTop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
  Scaffold { innerPadding ->
    Column(
      modifier = Modifier.padding(innerPadding)
    ) {
      ProvideCompositionLocals {
        BottomNavHost()
        BottomNavigation()
      }
    }
  }
}

@Composable
private fun BottomNavigation() {
  val navController = LocalHomeNavController.current
  val navBackStackEntry = navController.currentBackStackEntry
  val currentRoute = navBackStackEntry?.destination?.route
  NavigationBar {
    BottomNavItem.values().forEach { item ->
      BottomNavigationItem(item = item)
    }
  }
}

@Composable
private fun BottomNavigationItem(
  item: BottomNavItem
) {
  NavigationBarItem(
    selected = currentRoute == item.route,
    onClick = {
      navController.navigateSingleTop(item.route)
    },
    icon = {
      Icon(
        imageVector = item.icon(),
        contentDescription = item.label()
      )
    },
    label = {
      Text(text = item.label())
    }
  )
}

@Composable
private fun ProvideCompositionLocals(
  content: @Composable () -> Unit
) {
  val navController = rememberNavController()

  CompositionLocalProvider(
    LocalHomeNavController provides navController, 
    content = content
  )
}