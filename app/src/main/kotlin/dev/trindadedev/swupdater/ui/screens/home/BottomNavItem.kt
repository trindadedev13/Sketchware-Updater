package dev.trindadedev.swupdater.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BuildCircle

import dev.trindadedev.swupdater.Strings
import dev.trindadedev.swupdater.Drawables
import dev.trindadedev.swupdater.navigation.routes.NightlyBuildsRoute
import dev.trindadedev.swupdater.navigation.routes.GitHubCommitsRoute

/*
 * HomeScreen BottomNavigation itens
 */
sealed class BottomNavItem<T>(
  val route: T,
  val icon: @Composable () -> ImageVector, 
  val label: @Composable () -> String
) {
  object NightlyBuilds: BottomNavItem<NightlyBuildsRoute>(
    route = NightlyBuildsRoute,
    icon = {
      Icons.Rounded.BuildCircle
    },
    label = {
      stringResource(Strings.label_nightly_builds) 
    }
  )
  object GitHubCommits: BottomNavItem<GitHubCommitsRoute>(
    route = GitHubCommitsRoute,
    icon = {
      ImageVector.vectorResource(Drawables.ic_github) 
    },
    label = {
      stringResource(Strings.label_github_commits)
    }
  )
}