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

import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  viewModel: HomeViewModel
) {
  ProvideCompositionLocals {
    Scaffold(
      bottomBar = {
        BottomNavigation(viewModel)
      }
    ) {
      BottomNavHost()
    }
  }
}
@Composable
private fun BottomNavigation(
  viewModel: HomeViewModel
) {
  NavigationBar {
    BottomNavItem.toList().forEach { item ->
      BottomNavigationItem(
        item = item,
        viewModel = viewModel
      )
    }
  }
}

@Composable
private fun <T: Any> RowScope.BottomNavigationItem(
  item: BottomNavItem<T>,
  viewModel: HomeViewModel
) {
  val navController = LocalHomeNavController.current
  
  NavigationBarItem(
    selected = viewModel.currentRoute == item.route,
    alwaysShowLabel = viewModel.currentRoute == item.route,
    onClick = {
      if (!(viewModel.currentRoute == item.route)) {
        navController.navigateSingleTop(item.route)
        viewModel.setCurrentRoute(item.route)
      }
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