package dev.trindadedev.swupdater.ui.animations.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically

object NavigationAnimationTransitions {

  val enterTransition =
    fadeIn(tween(250)) + slideInVertically { it / 2 }

  val exitTransition =
    fadeOut(tween(200)) + slideOutVertically { -it / 2 }

  val popEnterTransition =
    fadeIn(tween(250)) + slideInVertically { -it / 2 }

  val popExitTransition =
    fadeOut(tween(200)) + slideOutVertically { it / 2 }
}