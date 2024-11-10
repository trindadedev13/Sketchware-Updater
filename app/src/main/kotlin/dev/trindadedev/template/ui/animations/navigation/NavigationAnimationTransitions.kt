package dev.trindadedev.template.ui.animations.navigation

import soup.compose.material.motion.animation.materialSharedAxisYIn
import soup.compose.material.motion.animation.materialSharedAxisYOut

object NavigationAnimationTransitions {

  val enterTransition =
    materialSharedAxisYIn(
      forward = true,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )

  val exitTransition =
    materialSharedAxisYOut(
      forward = true,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )

  val popEnterTransition =
    materialSharedAxisYIn(
      forward = false,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )

  val popExitTransition =
    materialSharedAxisYOut(
      forward = false,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )
}
