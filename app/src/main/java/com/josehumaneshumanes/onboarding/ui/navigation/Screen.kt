package com.josehumaneshumanes.onboarding.ui.navigation

sealed class Screen(val route: String) {
    object OnBoarding: Screen(route = "onBoarding")
    object Home: Screen(route = "home")
}
